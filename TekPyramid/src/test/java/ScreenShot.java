import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		
	TakesScreenshot ts=(TakesScreenshot)driver;
	File srcFile = ts.getScreenshotAs(OutputType.FILE);
	 String time = new Date().toString().replace(" ", "_").replace(":", "_");
	 System.out.println(time);
	try {
		FileUtils.copyFile(srcFile, new File("./ScreenShot/error+"+time+".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
