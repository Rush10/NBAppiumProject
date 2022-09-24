package ujian.ujiankelima.pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import ujian.ujiankelima.utils.*;

public class GoogleNews {

	public AndroidDriver<MobileElement> driver;

	public GoogleNews(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Locator tab
	@AndroidFindBy(id = "com.google.android.apps.magazines:id/tab_headlines")
	private MobileElement tabHeadlines;
	@AndroidFindBy(id = "com.google.android.apps.magazines:id/tab_following")
	private MobileElement tabFollowing;
	@AndroidFindBy(id = "com.google.android.apps.magazines:id/tab_store")
	private MobileElement tabNewsstand;
	
	//profile
	@AndroidFindBy(id = "com.google.android.apps.magazines:id/og_apd_internal_image_view")
	private MobileElement btnProfile;
	
	//back
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	private MobileElement btnBack;
	
	//setting
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView[2]/android.view.ViewGroup[3]")
	private MobileElement btnSetting;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
	private MobileElement menuSetting;
	
	//help
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView[2]/android.view.ViewGroup[4]")
	private MobileElement btnHelp;
	@AndroidFindBy(id = "com.google.android.gms:id/product_name")
	private MobileElement menuHelp;
	

	// locator title
	@AndroidFindBy(id = "com.google.android.apps.magazines:id/header_bar_title")
	private MobileElement titleBar;

	// Method
	public void goToPageHeadLines() {
		Utils.delay(3, Constants.GLOB_PARAM_DELAY);
		tabHeadlines.click();
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
	}

	public void goToPageFollowing() {
//		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
		tabFollowing.click();
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
	}

	public void goToPageNewsstand() {
//		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
		tabNewsstand.click();
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
	}
	
	public void goToPageSetting() {
//		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
		btnProfile.click();
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
		btnSetting.click();
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
	}
	
	public void back() {
//		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
		btnBack.click();
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
	}
	
	public void goToPageHelp() {
//		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
		btnProfile.click();
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
		btnHelp.click();
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
	}
	
	public String getTxtResultOfTab() {
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
		String title = titleBar.getText();
		System.out.println("Actual: " + title);
		return title;
	}
	
	public String getTxtResultOfSetting() {
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
		System.out.println("Actual: " + menuSetting.getText());
		return menuSetting.getText();
	}
	
	public String getTxtResultOfHelp() {
		Utils.delay(2, Constants.GLOB_PARAM_DELAY);
		System.out.println("Actual: " + menuHelp.getText());
		return menuHelp.getText();
	}
}
