package pur.ultimate.init;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InitConstants {
	/**静态文件版本号**/
	public static final String version = System.currentTimeMillis()+"";
	/**环境标识**/
	public static  String environment_flag ;
	/**开发模式**/
	public static  boolean devMode ;
	/**pageid 与 url 对应关系**/
	public static  ConcurrentMap<String,Integer> PAGE_PATH_ID = new ConcurrentHashMap<String,Integer>();
	
}
