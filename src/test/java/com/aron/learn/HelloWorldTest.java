package com.aron.learn;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest{
	private static Logger logger = Logger.getLogger(HelloWorldTest.class);

	@Before
	public void setBefore(){
		PropertyConfigurator.configure("conf/log4j.properties");
		logger.info("test start");

	}
	@After
	public void setAfter(){
		logger.info("test end");
	}

	@Test
	public void testSayHello(){
		HelloWorld helloWorld = new HelloWorld();
		String result = helloWorld.sayHello();
		assertEquals("Hello Maven!!!", result);
	}

	@Test
	public void testCommon() throws Exception{
		System.out.println("ok 欢迎");
	}
}