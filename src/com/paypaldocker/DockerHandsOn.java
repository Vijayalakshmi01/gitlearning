package com.paypaldocker;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DockerHandsOn {
	

	public void setRemoteDriver(String browser){
		DesiredCapabilities cap = null;
		
		if(browser.equals("Firefox")){
			cap = DesiredCapabilities.firefox();
		}else if(browser.equals("Chrome")){
			cap = DesiredCapabilities.chrome();
		}
		try {
		WebDriver driver1 = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(invocationCount = 3)
	public void enterGoogleSearchTextChrome() throws InterruptedException{
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = null;
		try {
			
			driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement textbox = driver.findElement(By.name("q"));
		textbox.clear();
//		System.out.println("Executing in chrome: " + method.getCurrentInvocationCount());
		textbox.sendKeys("Docker introduction");
		textbox.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.close();

//		sa.assertTrue(driver.getTitle().contains(text), "Google Search not performed for text: " + text);



}
	

	@Test(invocationCount = 3)
	public void enterGoogleSearchTextFF() throws InterruptedException{
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		setRemoteDriver("Firefox");
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement textbox = driver.findElement(By.name("q"));
		textbox.clear();

//		System.out.println("Executing in firefox: " + method.getCurrentInvocationCount());
		textbox.sendKeys("Selenium testing");
		textbox.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.close();

//		sa.assertTrue(driver.getTitle().contains(text), "Google Search not performed for text: " + text);


}
	
//	@Test(dataProvider = "FireFoxData")
//	public void scaleChromeBrowser() throws InterruptedException{
//		setRemoteDriver("Firefox");
//		driver.get("http://www.google.com");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		WebElement textbox = driver.findElement(By.name("q"));
//		textbox.clear();
//		textbox.sendKeys("Selenium testing");
//		textbox.sendKeys(Keys.ENTER);
//		Thread.sleep(4000);
//	}
//	
//	@DataProvider(name="FireFoxData")
//	public void provideSearchText(){
//		
//	}
//	
//	@Test
//	public void scaleFirefoxBrowser(){
//		
//	}
	
	
/*	@AfterMethod
	public void closeDriver(){
		driver.quit();
	}*/
}
