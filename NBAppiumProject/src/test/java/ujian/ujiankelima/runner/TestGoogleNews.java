package ujian.ujiankelima.runner;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ujian.ujiankelima.pageobject.GoogleNews;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import ujian.ujiankelima.utils.*;

public class TestGoogleNews { 

	private static AndroidDriver<MobileElement> driver;
	private GoogleNews news;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ASUS_Z01QD");
		capabilities.setCapability("uuid", "127.0.0.1:21503");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.2");
		capabilities.setCapability("appPackage", "com.google.android.apps.magazines");
		capabilities.setCapability("appActivity", "com.google.apps.dots.android.app.activity.CurrentsStartActivity");//automationName
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformVersion", "7.1.2");
//		capabilities.setCapability("appWaitDuration", "600");
//		capabilities.setCapability("adbExecTimeout", "600");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//		System.out.println("DRIVER : "+driver);
	}
	
	@BeforeMethod
	public void pageObject() {
		news = new GoogleNews(driver);
	}
	
	@Test(priority = 1)
	public void testGoToPageHeadLines() {
		String strExpected = "Headlines";
		System.out.println("===== Test Go To Page HeadLines =====");
		news.goToPageHeadLines();
		System.out.println("Expected: " + strExpected);
		assertEquals(news.getTxtResultOfTab(), strExpected);
		System.out.println("=====================================");
	}
	
	@Test(priority = 2)
	public void testGoToPageFollowing() {
		String strExpected = "Following";
		System.out.println("===== Test Go To Page Following =====");
		news.goToPageFollowing();
		System.out.println("Expected: " + strExpected);
		assertEquals(news.getTxtResultOfTab(), strExpected);
		System.out.println("=====================================");
	}
	
	@Test(priority = 3)
	public void testGoToPageNewsstand() {
		String strExpected = "Newsstand";
		System.out.println("===== Test Go To Page Newsstand =====");
		news.goToPageNewsstand();
		System.out.println("Expected: " + strExpected);
		assertEquals(news.getTxtResultOfTab(), strExpected);
		System.out.println("=====================================");
	}
	
	@Test(priority = 4)
	public void testGoToPageSetting() {
		String strExpected = "Settings";
		System.out.println("===== Test Go To Page Setting =====");
		news.goToPageSetting();
		System.out.println("Expected: " + strExpected);
		assertEquals(news.getTxtResultOfSetting(), strExpected);
		news.back();
		System.out.println("=====================================");
	}
	
	@Test(priority = 5)
	public void testGoToHelp() {
		String strExpected = "Help";
		System.out.println("===== Test Go To Page Help =====");
		news.goToPageHelp();
		System.out.println("Expected: " + strExpected);
		assertEquals(news.getTxtResultOfHelp(), strExpected);
		System.out.println("=====================================");
	}
	
	
	@AfterClass
	public void closeApp() {
		driver.quit();
	}	
}