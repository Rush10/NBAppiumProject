package latihan.appium.app.utils;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;

public class ExcelTest {

	public static void main(String[] args) {
		Object [][] dDriven ;
		int intColumnNums = 0, intRowNums = 0;
		String excelPath = "./data/DataDriven.xlsx";
		String sheetName = "Sheet1";
		ExcelReader excelReader = new ExcelReader(excelPath, sheetName);
		
		intRowNums = excelReader.getRowCount();
		intColumnNums = excelReader.getColCount();
		
		dDriven = new Object[intRowNums][intColumnNums];
		
		Iterator<Row> rX = excelReader.getIter();
		int a=0;
		while(rX.hasNext())
		{
			Row rows = rX.next();
			for(int j=0;j<intColumnNums;j++)
			{
				dDriven[a][j] = excelReader.getCellData(a, j);
				System.out.println(dDriven[a][j]);
			}
			a++;
		}

//		excelReader.getIter();
//		System.out.println(System.getProperty("user.dir"));
	}
}