package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataExcelBasedOnConditions {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String ExpectedId="TC_001";
		boolean flag=false;
		String data1="";

		FileInputStream fis=new FileInputStream("./src/test/resources/TeckPyramid2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		for(int i=0;i<=rowCount;i++) {
			String data=sheet.getRow(i).getCell(0).getStringCellValue();
			if(data.equals(ExpectedId)) {
			
				 data1=sheet.getRow(i).getCell(1).getStringCellValue();
			break;
						}
		}
		if(flag==true) {
			System.out.println(data1);

		}

					else {
				System.out.println(ExpectedId +"data is not Awailable");
			}
		}
		
	
	

}
