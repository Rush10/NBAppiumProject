package latihan.appium.app.runner;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import latihan.appium.app.pageobject.CalculatorDestroyer;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import latihan.appium.app.utils.ExcelReader;

public class TestCalculatorDestroyer {

	private static AndroidDriver<MobileElement> driver;
	private CalculatorDestroyer calcDestroyer;
	private ExcelReader excelReader;
	private Object [][] dDriven ;
	private int intColumnNums;
	private int intRowNums;
	private int intNumX=0;
	private int intNumNext = 0;
	private int intLoopCalc =0;
	private int intOperator = 0;
	private double doubResultExpected = 0.0;
	private double doubResultActual = 0.0;
	private Random rand ;
	
	@BeforeTest
	public void befTest()
	{
		
		try {
			
			rand = new Random();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "ASUS Z01QD");
			capabilities.setCapability("uuid", "127.0.0.1:21513");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "7.1.2");
			capabilities.setCapability("appPackage", "com.google.android.calculator");
			capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
			
				driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			
			String excelPath = "./data/DataDriven.xlsx";
			String sheetName = "Sheet1";
			excelReader = new ExcelReader(excelPath, sheetName);
			intRowNums = excelReader.getRowCount();
			intColumnNums = excelReader.getColCount();
			calcDestroyer = new CalculatorDestroyer(driver);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "DataProviderFirst")
	public Object[][] dataDrivenPost()
	{
		dDriven = new Object[intRowNums][intColumnNums];
		
		Iterator<Row> rX = excelReader.getIter();
		int a=0;
		while(rX.hasNext())
		{
			Row rows = rX.next();
			for(int j=0;j<intColumnNums;j++)
			{
				dDriven[a][j] = excelReader.getCellData(a, j);
//				System.out.println(dDriven[a][j]);
			}
			a++;
		}
		return dDriven;		
	}
	
	@Test(priority = 0,dataProvider="DataProviderFirst")
	public void testPost(String x) throws InterruptedException
	{		
		StringBuffer strTambah = new StringBuffer(""); 
		String strOperator = "";
		System.out.println("Loop ke-" + x);
//		intLoopCalc = rand.nextInt(15);
		intLoopCalc = 3;
		intNumX = rand.nextInt(10);
		for(int i=0;i<intLoopCalc;i++)
		{
			intNumNext = rand.nextInt(10);
			intOperator = rand.nextInt(5); //(perbaikan) salah informasi disini, randomnya mulai dari angka 0-4 padahal operator dengan angka 4 tidak ada sehingga angka 0 & 4 akan didefinisikan ke else atau sebagai substract(-).
//			public double getResult(double result,int number, int operator)
			
			if(intOperator==1)
			{			
				strOperator = "*";
			}
			else if(intOperator==2)
			{
				strOperator = "/";
			}
			else if(intOperator == 3)
			{
				strOperator = "+";
			}
			else
			{
				strOperator = "-";
			}
			
			if(i==0)
			{
				strTambah.append(intNumX + "," + strOperator + ",");
				doubResultExpected = calcDestroyer.initCalc(intNumX,intNumNext, intOperator);
			}
			else
			{
				strTambah.append(intNumNext + "," + strOperator + ",");
				doubResultExpected = calcDestroyer.getResult(doubResultExpected,intNumNext,intOperator);
			}
		}
		calcDestroyer.doEqualz();
		doubResultActual = calcDestroyer.getTxtResult();
		System.out.println(strTambah);
		System.out.println("ACTUAL : "+doubResultActual+" --- EXPECTED : "+doubResultExpected);
		Thread.sleep(5000);
		assertEquals(doubResultActual, doubResultExpected);
		calcDestroyer.clear();
	}
}