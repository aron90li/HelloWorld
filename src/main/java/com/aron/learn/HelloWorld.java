package com.aron.learn;

import cn.itcast.commons.CommonUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HelloWorld{
	private static Logger logger = Logger.getLogger(HelloWorld.class);

	public String sayHello(){
		return "Hello Maven!!!";
	}
	
	public static void main(String[] args){

		PropertyConfigurator.configure("conf/log4j.properties");
		logger.info("program start...");
		System.out.println(new HelloWorld().sayHello());
		System.out.println(CommonUtils.uuid());
		System.out.println("你好");
		logger.info("haha");

	}
}