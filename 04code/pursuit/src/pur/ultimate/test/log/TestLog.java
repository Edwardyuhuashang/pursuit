package pur.ultimate.test.log;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog {
	Logger logger = Logger.getLogger(getClass());
	Logger rootlog = Logger.getRootLogger();
	
	public String log (){
		try {
			Properties prop = new Properties();
			URL url = this.getClass().getResource("/properties/log4j.properties");
			prop.load(url.openStream());
			PropertyConfigurator.configure(prop); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("test log");
		return "log run";
	}
	
	public String log1 (){
//		try {
//			Properties prop = new Properties();
//			URL url = this.getClass().getResource("/properties/log4j.properties");
//			prop.load(url.openStream());
//			PropertyConfigurator.configure(prop); 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		logger.info("test log1");
		return "log run";
	}
	public String rootlog (){
//		try {
//			Properties prop = new Properties();
//			URL url = this.getClass().getResource("/properties/log4j.properties");
//			prop.load(url.openStream());
//			PropertyConfigurator.configure(prop); 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		rootlog.info("test rootlog");
		return "log run";
	}
	
	public static void main(String[] args) {
		TestLog log = new TestLog();
		log.rootlog();
		log.log();
		log.log1();
		log.rootlog();

	}

}
