package Test_Pack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base_Pack.Base_Class;
import POM_Pack.Admin_Users;
import POM_Pack.LandingPage;
import POM_Pack.Login_Page;
import Util_Pack.Util;

public class CreateUserTest extends Base_Class {
	
	WebDriver driver;
	Properties prop;
	FileInputStream propfile;
	Login_Page login;
	LandingPage landingpage;
	Admin_Users users;
	String xlsfile = "C:\\Users\\SwapnilHage\\eclipse-workspace\\Maven\\src\\main\\java\\ExcelData.xlsx";
	
	@org.testng.annotations.BeforeClass
	public void BeforeClass() throws IOException {
		
		driver = openChromeBrowser();	
		prop = property();
		
		System.out.println(prop.getProperty("url"));

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		login = new Login_Page(driver);
		landingpage = new LandingPage(driver);
		users = new Admin_Users(driver);
	}
	
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test (priority = 1)
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
		Thread.sleep(1000);
		
	}
	
	@Test (priority = 2)
	public void createUser() throws EncryptedDocumentException, IOException, InterruptedException {
		
		Util reader = new Util();
		int rowcount = reader.getRowCount(xlsfile, "UNP");
		System.out.println("Rowcount   " + rowcount);

		landingpage.clickAdministration();

		users.newButton();
		users.userOption();
		users.enterUserId(reader.getexceldata(xlsfile, "Users", 1, 0));
		users.enterPassword(reader.getexceldata(xlsfile, "Users", 1, 1));
		users.enterConfirmPassword(reader.getexceldata(xlsfile, "Users", 1, 2));
		users.enterFirstName(reader.getexceldata(xlsfile, "Users", 1, 3));
		users.enterLastName(reader.getexceldata(xlsfile, "Users", 1, 4));
		users.enterEmail(reader.getexceldata(xlsfile, "Users", 1, 5));
		users.clickAdminToggleBtn();
		Thread.sleep(1000);
		users.clickSaveBtn();
		
		Thread.sleep(1000);
		String validationMsg1 = users.getValidationMsg();
		System.out.println(validationMsg1);
		
		Assert.assertEquals(validationMsg1, "swapnil.h@toranainc.com Email Already Exists.");
		
	}
	
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		
	//	driver.close();
	}

}
