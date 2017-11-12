package com.googlesearch;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TimeOutChecker {

	@Test(timeOut = 2000, invocationCount = 5, threadPoolSize = 2)
	public void test(){
		int count = 0;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(++count + " Executed successfully");
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][]{
			{"One"},
			{"Two"},
			{"Three"},
			{"Four"},
			{"Five"}
		};
		
	}
}
