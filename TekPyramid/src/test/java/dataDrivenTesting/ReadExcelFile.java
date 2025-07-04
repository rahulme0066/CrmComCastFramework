package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		
		
	//	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/PracticeTek.xlsx");
		FileInputStream fis=new FileInputStream("./src/test/resources/PracticeTek.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		//int rowCount = sheet.getLastRowNum();
		  String num = sheet.getRow(1).getCell(2).toString();
		System.out.println(num);
		
		
		

	}

}
