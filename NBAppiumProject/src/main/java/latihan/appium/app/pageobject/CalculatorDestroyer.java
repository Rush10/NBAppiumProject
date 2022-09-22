package latihan.appium.app.pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalculatorDestroyer {

	public AndroidDriver<MobileElement> driver;
	private double doubExpected=0.0;	
	
	public CalculatorDestroyer(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Locator number
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
	private MobileElement btnOne;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
	private MobileElement btnTwo;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
	private MobileElement btnThree;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
	private MobileElement btnFour;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_5")
	private MobileElement btnFive;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_6")
	private MobileElement btnSix;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_7")
	private MobileElement btnSeven;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_8")
	private MobileElement btnEight;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_9")
	private MobileElement btnNine;
	@AndroidFindBy(id = "com.google.android.calculator:id/digit_0")//penambahan btnZero
	private MobileElement btnZero;
	
	// locator aritmatika
	@AndroidFindBy(id = "com.google.android.calculator:id/op_add")
	private MobileElement btnAdd;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_sub")
	private MobileElement btnSubstract;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_mul")
	private MobileElement btnMultiply;
	@AndroidFindBy(id = "com.google.android.calculator:id/op_div")
	private MobileElement btnDivide;
	@AndroidFindBy(id = "com.google.android.calculator:id/eq")
	private MobileElement btnEquals;
	@AndroidFindBy(id = "com.google.android.calculator:id/clr")
	private MobileElement btnClear;

	// locator result
	@AndroidFindBy(id = "com.google.android.calculator:id/result_final")
	private MobileElement resultCalc;

	public int getNumber(int number) //salah disini, tidak ada btnZero sehingga ketika ada angka random 0 maka akan masuk ke else dan menginputkan angka 9 ke calculator tetapi program java tetap menghitung nilai 0
	{
		if(number==1)
		{			
			btnOne.click();
			return 1;
		}
		else if(number==2)
		{
			btnTwo.click();
			return 2;
		}
		else if(number==3)
		{
			btnThree.click();
			return 3;
		}else if(number==4)
		{
			btnFour.click();
			return 4;
		}else if(number==5)
		{
			btnFive.click();
			return 5;
		}else if(number==6)
		{
			btnSix.click();
			return 6;
		}
		else if(number==7)
		{
			btnSeven.click();
			return 7;
		}
		else if(number==8)
		{
			btnEight.click();
			return 8;
		}
		else 
		{
			btnNine.click();
			return 9;
		}
	}
	
	public double getResult(double result,int number, int operator)  
	{
		if(operator==1)
		{			
			btnMultiply.click();System.out.println("*");
			System.out.println(getNumber(number));
			btnEquals.click();
			result = result * (double)number;
		}
		else if(operator==2)
		{
			btnDivide.click();System.out.println("/");
			System.out.println(getNumber(number));
			btnEquals.click();
			result = result / (double)number;
		}
		else if(operator == 3)
		{
			btnAdd.click();System.out.println("+");
			System.out.println(getNumber(number));
			btnEquals.click();
			result = result + (double)number;
		}
		else
		{
			btnAdd.click();System.out.println("+"); //salah disini, seharusnya btnSubstract
			System.out.println(getNumber(number));
			btnEquals.click();
			result = result - (double)number;
		}
		
		return result;
	}
	
	public double initCalc(int numberX , int numberY, int operator)
	{
		if(operator==1)
		{	
			System.out.println(getNumber(numberX));
			btnMultiply.click();System.out.println("*");
			System.out.println(getNumber(numberY)); 
			btnEquals.click();
			doubExpected = (double)numberX * (double)numberY;
		}
		else if(operator==2)
		{
			System.out.println(getNumber(numberX));
			btnDivide.click();System.out.println("/");
			System.out.println(getNumber(numberY)); 
			btnEquals.click();
			doubExpected = (double)numberX / (double)numberY;
		}
		else if(operator == 3)
		{
			System.out.println(getNumber(numberX));
			btnAdd.click();System.out.println("+");
			System.out.println(getNumber(numberY)); 
			btnEquals.click();
			doubExpected = (double)numberX + (double)numberY;
		}
		else
		{
			System.out.println(getNumber(numberX));
			btnSubstract.click();System.out.println("-");
			System.out.println(getNumber(numberY)); 
			btnEquals.click();
			doubExpected = (double)numberX - (double)numberY;
		}
		return doubExpected;
	}
	
	public void doEqualz() {
		btnEquals.click();
	}
	
	public double getTxtResult() {
		return Double.parseDouble(resultCalc.getText());
	}
	
	public String getTxtResultInfinity() { //mencoba get text infinity calculator
		return resultCalc.getText();
	}

	public void clear() {
		btnClear.click();
	}
	
	public void infinityActual() { //method untuk mencoba membandingkan infinity java dan calculator google
		System.out.println("ACTUAL");
		btnEight.click();System.out.println("Nilai 1: 8");
		btnDivide.click();System.out.println("Operator: /");
		btnZero.click();System.out.println("Nilai 2: 0");
		btnEquals.click();
	}
	
	public double infinityExpected() { //method untuk mencoba membandingkan infinity java dan calculator google
		double dDevide = 0.0;
		double dValue1 = 8.0;
		int intValue2 = 0;
		
		System.out.println("EXPECTED");
		System.out.println("Nilai 1:" + dValue1);
		System.out.println("Operator: /");
		System.out.println("Nilai 2:" + intValue2);
		
		dDevide = dValue1/intValue2;
		
		System.out.println("Hasil Expected:" + dDevide);
		
		return dDevide;
	}
}
