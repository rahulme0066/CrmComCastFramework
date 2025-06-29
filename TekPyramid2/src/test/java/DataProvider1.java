import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;


public class DataProvider1 {
	
	@Test(dataProvider = "getData")
	public void pricceInfo(String brandName,String productName ) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("https://www.amazon.in");
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		String x="//span[text()='"+productName+"']/../../../..//span//span[2]//span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtility elib=new ExcelUtility();
		int rowCount = elib.getRowCount("Product");
		Object[][]  objArr=new Object[rowCount][2];
		for(int i=0;i<rowCount;i++) {
			objArr[i][0]=elib.getDataFromExcel("Product",i+1 , 0);
			objArr[i][1]=elib.getDataFromExcel("Product",i+1 , 1);


		}
		return objArr;
		
	}

}
