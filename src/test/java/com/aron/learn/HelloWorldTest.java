package com.aron.learn;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		//System.out.println("ok 欢迎");

		int[] a= {3,1,9,8,7,9,1,3,4,6,0};
		quickSort(a, 0, 10);
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		//System.out.println(Arrays.asList(a));

	}

	public  static void quickSort(int[] arr, int low, int high) {
		if(low > high) {
			return;
		}
		int i = low;
		int j =high;
		int pivot = arr[low];

		while(i < j) {
			while(i < j && arr[j] > pivot) j--;
			while(i < j && arr[i] <= pivot) i++;
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		//将原中轴和arr[i] 互换
		int temp = arr[i];
		arr[i] = arr[low];
		arr[low] = temp;

		quickSort(arr,low, i-1 );
		quickSort(arr,i + 1, high);
	}
	@Test
	public void testOOM() {
//		int i = 0;
//		List<String> list = new ArrayList<>();
//		while(true) {
//			list.add(String.valueOf(i++).intern());
//		}

		String s = new StringBuilder("hello").toString();
		String s1 = "hello";
		System.out.println(s == s1);
		System.out.println(s.intern() == s );

	}
}