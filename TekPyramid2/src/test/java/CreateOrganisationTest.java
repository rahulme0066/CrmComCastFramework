import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateOrganisationTest {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get("http:/localhost:8888");
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.usernameEdt.sendKeys("admin");

	}

}
