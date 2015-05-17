package dengine.ultimate.http;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

/**
 * 
 * 类描述： 创建人：licl 创建时间：2013-1-18 下午03:08:15 修改人： 修改时间： 修改备注：
 * 
 * @version
 * @see
 * @since iJCF V2.0
 * 
 */
public class HttpUtil {
	private static Log log = LogFactory.getLog(HttpUtil.class);

	public static final int HTTP_METHOD_GET = 1;
	public static final int HTTP_METHOD_POST = 2;
	// public static final int HTTP_METHOD_PUT = 3;
	// public static final int HTTP_METHOD_DELETE = 4;

	// public static final int HTTP_PARA_TYPE_JSON = 1;
	// public static final int HTTP_PARA_TYPE_XML = 2;

	// private static Charset CHARSET = Charset.forName("UTF-8");

	private static final int HTTPCLIENT_MAXTOTAL = 3000;
	private static final int HTTPCLIENT_MAXPERROUTE = 1000;
	private static final int HTTPCLIENT_CONTIMEOUT = 60000;
	private static final int HTTPCLIENT_SOTIMEOUT = 50000;
	private static PoolingClientConnectionManager conMan = null;
	static {
		conMan = new PoolingClientConnectionManager(
				SchemeRegistryFactory.createDefault());
		conMan.setMaxTotal(HTTPCLIENT_MAXTOTAL);// 对应池里允许的最大连接数
		conMan.setDefaultMaxPerRoute(HTTPCLIENT_MAXPERROUTE);// 每个域名允许最多个连接
	}

	public static String invoke(String url, String pin, String requestCharset,
			String responseCharset) {
		return invoke(url, HTTP_METHOD_POST, pin, requestCharset,
				responseCharset);
	}

	public static String invoke(String url, int method, String pin,
			String requestCharset, String responseCharset) {
		if (log.isDebugEnabled()) {
			log.debug("pin=" + pin);
		}
		DefaultHttpClient httpClient = null;
		try {
			httpClient = new DefaultHttpClient(conMan);
			// The following parameter configurations are not
			// neccessary for this example, but they show how
			// to further tweak the HttpClient
			HttpParams params = httpClient.getParams();
			HttpConnectionParams.setConnectionTimeout(params,
					HTTPCLIENT_CONTIMEOUT);// 连接超时时间
			HttpConnectionParams.setSoTimeout(params, HTTPCLIENT_SOTIMEOUT); // 数据传输超时
			url = url.trim();
			HttpUriRequest request = httpMethod(url, method, pin,
					requestCharset);
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			StatusLine status = response.getStatusLine();
			int statusCode = status.getStatusCode();
			String returnStr = EntityUtils.toString(entity, responseCharset);
			if (200 != statusCode) {
				// EntityUtils.consume(entity);
				// throw new RuntimeException("http status code " +
				// statusCode+"\n"+EntityUtils.toString(entity,CHARSET));
				// System.out.println(url+",http status code:" +
				// statusCode+"\n"+new String(returnStr.getBytes(),"UTF-8"));
				log.info(url + ",http status code:" + statusCode + "\n"
						+ returnStr);
			}
			// System.out.println(httpClient.getConnectionManager());
			return returnStr;
		} catch (ClientProtocolException cpe) {
			throw new RuntimeException("call [" + url + "] error!", cpe);
		} catch (IOException ioe) {
			throw new RuntimeException("call [" + url + "] error!", ioe);
		} 
//		finally {
//			if (httpClient != null) {
//				httpClient = null;
//			}
//		}
	}

	private static HttpUriRequest httpMethod(String url, int method,
			String pin, String requestCharset) {
		switch (method) {
		case HTTP_METHOD_GET:
			return new HttpGet(url);
		case HTTP_METHOD_POST:
			HttpPost httpPost = new HttpPost(url);
			if (!(null == pin || "".equals(pin))) {
				StringEntity reqEntity = new StringEntity(pin,
						Charset.forName(requestCharset));
				if ('<' == pin.charAt(0)) {
					reqEntity.setContentType("application/xml;charset="
							+ requestCharset);
					httpPost.setHeader("Accept", "application/xml");
				} else {
					reqEntity.setContentType("application/json;charset="
							+ requestCharset);
					// httpPost.setHeader("Accept", "application/json");
				}
				httpPost.setEntity(reqEntity);
			}
			return httpPost;
			// case HTTP_METHOD_PUT:
			// HttpPut
			// case HTTP_METHOD_DELETE:

		default:
			throw new RuntimeException("http method [" + method
					+ "] no implement!");
		}
	}

	public static void main(String[] args) {
		// String url =
		// "http://172.21.3.96:51000/esbWS/rest/com_sitech_basemng_atom_inter_login_ILoginPdomList_qryLoginPdomList";
		// String param = FileIntoString.getFileToString("d:\\file.txt");
		// String result = HttpUtil.invoke(url,HttpUtil.HTTP_METHOD_POST,
		// param,"UTF-8","UTF-8");
		// System.out.println(result);
	}
}
