package Test_Pack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Base_Pack.Base_Class;
import POM_Pack.Login_Page;
import Util_Pack.Util;

public class LoginTest extends Base_Class {

	WebDriver driver;
	Properties prop;
	FileInputStream propfile;
	Login_Page login;
	
	@org.testng.annotations.BeforeClass
	public void BeforeClass() {
		
		driver = openChromeBrowser();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() throws IOException {
		
		prop = property();
		
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		login = new Login_Page(driver);
	}
	
	@Test
	public void loginTest() {
		
		login.click_Advancedbtn();
		login.proceedlink();
		login.selectRepo(prop.getProperty("repo"));
		login.click_Nextbtn();
		login.userName(prop.getProperty("username"));
		login.password(prop.getProperty("password"));
		login.signinBtn();
		
		String validationMsg = login.getValidationMsg();
		System.out.println(validationMsg);
	}
}
