package dataDrivenTesting;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPropertyFilesUsingScanner {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the browser");
		String browser = sc.next();
		System.out.println(browser);
		WebDriver driver=null;
		if(browser.equals("Chrome")){
			driver=new ChromeDriver();
		}
		else if(browser.equals("Firefox")){
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
	

	}

}
