package pur.ultimate.action;
import java.io.PrintWriter;
/**
 * @see action基类
 * @author MRCHEN
 *
 */
public class BaseAction extends RootAction {
	private static final long serialVersionUID = 1L;
	/**
	 * @see 将html写入
	 * @param str
	 */
	protected void write(String str){
		PrintWriter pw = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			pw = response.getWriter();
			if(!"".equals(str)&&str!=null){
				pw.write(str);
				
			}else{
				pw.write("");
			}
		} catch (Exception e) {
			logger.error("向浏览器写入html异常:",e);
		}finally{
			if(pw!=null){
				pw.close();
			}
		}
	}
	
	/**
	 * @see 将text写入
	 * @param str
	 */
	protected void writeText(String str){
		PrintWriter pw = null;
		try {
			response.setContentType("text/plain;charset=UTF-8");
			pw = response.getWriter();
			pw.write(str);
		} catch (Exception e) {
			logger.error("向浏览器写入plain异常:",e);
		}finally{
			if(pw!=null){
				pw.close();
			}
		}
	}
	protected String basePath(){
		return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
	}
	
}
