/*package com.sitech.dform.core.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.log4j.Logger;

import com.sitech.dform.vo.entity.ElementConf;
import com.sun.jndi.toolkit.url.Uri;
*//**
 * 读取配置文件并转化为bean对象(config/dfrom.xml)
 * @author litao
 *
 *//*
public class ConfigManager {
	private Logger logger = Logger.getLogger(this.getClass());
	
	private static final String ruleFileName = "config/elementRule.xml";
	
	private static ConfigManager instance ;
	private List<ElementConf> elementConfs;
	private ConfigManager(){
		if(instance == null){
			init();
		}
	}
	
	public static ConfigManager getInstance(){
		if(instance == null){
			instance = new ConfigManager();
		}
		return instance;
	}
	
	private synchronized void init(){
		String configFileName = "config/dform.xml";
		//String file = Thread.currentThread().getContextClassLoader().getResource(configFileName).getFile();//路径有特殊字符出错
		elementConfs = loadElementsConfig(configFileName);
		
		//扫描某个规则下的配置文件，读入（插件形式）===
	}
	
	public List<ElementConf> getElementConf(){
		return elementConfs;
	}
	
	
	
	public List<ElementConf> loadElementsConfig(String configFileName){
		URL rulesURL =  Thread.currentThread().getContextClassLoader().getResource(ruleFileName);
        if (rulesURL == null) {
            throw new RuntimeException("Unable to find rules file.");
        }
        Digester dig = DigesterLoader.createDigester(rulesURL);
        //设置对XML文档资料是否进行DTD验证 
        dig.setValidating( false ); 
        List<ElementConf> list = new ArrayList<ElementConf>();
        dig.push(list);
        
        // Process the input file.
        try {
            File srcfile = new File(configFileName);
           	dig.parse(Thread.currentThread().getContextClassLoader().getResource(configFileName).openStream());
        }
        catch(IOException ioe) {
        	logger.error("读取配置文件出错："+configFileName,ioe);
        }
        catch(org.xml.sax.SAXException se) {
        	logger.error("配置文件解析出错："+configFileName,se);
        }
        return list;
	}
	
	public void reload(){
		init();
	}
	
	public static void main(String[] args){
		ConfigManager cm = new ConfigManager();
		String configFileName = "config/dform.xml";
		String file = ClassLoader.getSystemResource(configFileName).getFile();
		List<ElementConf> list = cm.loadElementsConfig(file);
		System.out.println(list.size());
	}
}
*/