package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelFilemultiColumn {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/PracticeTek.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		for(int i=1 ;i<=rowCount;i++) {
			String data1 = sheet.getRow(i).getCell(0).toString();
			String data2 = sheet.getRow(i).getCell(1).toString();

			System.out.println(data1+" \t"+data2);
	
		}
		wb.close();
		
		
	}

}
