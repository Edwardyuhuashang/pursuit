package pur.ultimate.action;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

//import com.sitech.dform.core.util.ConfigManager;


/**
 * 读取配置文件的监听
 * @author litao
 *
 */
public class DformConfigListener implements ServletContextListener  {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		initLog4j();
//		ConfigManager.getInstance();//配置信息初始化到内存
//		DfromToolFactory.getInstance();
	}
	
	
	private void initLog4j(){
		try {
			Properties prop = new Properties();
			//URL url = this.getClass().getResource("/properties/log4j.properties");
			URL url1 = Thread.currentThread().getContextClassLoader().getResource("properties/log4j.properties");
			prop.load(url1.openStream());
			PropertyConfigurator.configure(prop); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
