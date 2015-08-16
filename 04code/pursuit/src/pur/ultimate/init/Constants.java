package pur.ultimate.init;

/**
 * 系统常量
 * @author xuhf
 *
 */
public class Constants {

	/**请求参数来源**/
	public static final String AUTO = "auto";
	public static final String SESSION = "session";
	public static final String REQUEST = "request";
	public static final String PAGE = "page";
	public static final String DYNAMICPAGE = "dynamicPage";
	public static final String JSON = "jsonStr";
	public static final String SYSTEMTIME = "systemTime";//系统时间
	public static final String SYSTEMIP = "systemIP";//系统ip
	public static final String SESSIONID = "sessionId";//sessionid
	public static final String DIY = "diyDefine";//自定义
	
	/**结果对应关系--数据来源**/
	public static final String DS_WEBSERVICE = "webservice";
	public static final String DS_JAVASCRIPT = "javascript";
	public static final String DS_JAVA = "java"; 
	public static final String DS_FREEMARKER = "freemarker";
	public static final String DS_REQUEST = "request";
	public static final String DS_SESSION = "session";
	
	/**环境标识：开发环境**/
	public static final String DEVELOP = "develop";
	/**环境标识：测试环境**/
	public static final String TEST = "test";
	/**环境标识：仿真环境**/
	public static final String SIMULATE = "simulate";
	/**环境标识：生产环境**/
	public static final String PRODUCT = "product";
	/**项目名称**/
	public static final String PRODUCTCRM = "CRM6";
	public static final String PRODUCTSHAGNHAI = "SHANGHAI";
	
	/**项目名称**/
	public static final String CACHE_PREVENTBYPASS = "CACHE_PREVENTBYPASS";
	
	/**
	 * 加密类型 <br>none:不加密 <br>base64:base64加密
	 * @author mahui
	 */
	public static class encryptType{
		/**不加密*/
		public static final int none = 0;
		/**base64加密、解密*/
		public static final int base64 = 1;
		/**base64加密、解密后使用des进行加密*/
		public static final int base64_des = 2;
		/**base64加密、解密后使用des进行加密,登录使用*/
		public static final int base64_des_login = 3;
	}

}
