package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel2 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Ninja.properties");
		  Properties prop = new  Properties();
		  prop.load(fis);

		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("Url");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		
		//read data from excel file
		FileInputStream fis1=new FileInputStream("./src/test/resources/Organisation.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("org");
		int rowCount = sheet.getLastRowNum();
		for(int i=0;i<=rowCount;i++) {
		
			String value = sheet.getRow(i).getCell(1).toString();
			System.out.println(value);
	
	
			
	
	
       wb.close();


	}

}
}
