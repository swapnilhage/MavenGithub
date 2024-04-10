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
import POM_Pack.LandingPage;
import POM_Pack.Login_Page;
import Util_Pack.Util;

public class LoginTest extends Base_Class {

	WebDriver driver;
	Properties prop;
	FileInputStream propfile;
	Login_Page login;
	LandingPage landingpage;
	
	@org.testng.annotations.BeforeClass
	public void BeforeClass() {
		
		driver = openChromeBrowser();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		login = new Login_Page(driver);
		landingpage = new LandingPage(driver);
	}
	
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() throws IOException {	
		prop = property();
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		
		login.click_Advancedbtn();
		login.proceedlink();
		login.selectRepo(prop.getProperty("repo"));
		login.click_Nextbtn();
		login.userName(prop.getProperty("username"));
		login.password(prop.getProperty("password"));
		login.signinBtn();
		Thread.sleep(1000);
		String validationMsg = landingpage.getValidationMsg();
		System.out.println(validationMsg);
	}
}
