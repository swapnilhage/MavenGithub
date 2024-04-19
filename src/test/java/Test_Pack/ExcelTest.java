package Test_Pack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base_Pack.Base_Class;
import POM_Pack.LandingPage;
import POM_Pack.Login_Page;
import Util_Pack.Util;

public class ExcelTest extends Base_Class {
	
	WebDriver driver;
	Properties prop;
	FileInputStream files;
	Login_Page login;
	LandingPage landingpage;
	String xlsfile = "C:\\Users\\SwapnilHage\\eclipse-workspace\\Maven\\src\\main\\java\\ExcelData.xlsx";
	
	@org.testng.annotations.BeforeClass
	public void BeforeClass() {
		
		driver = openChromeBrowser();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() throws IOException {
		
		prop = new Properties();
		files = new FileInputStream("C:\\Users\\SwapnilHage\\eclipse-workspace\\Maven\\src\\main\\java\\config.properties");
		prop.load(files);
		
		System.out.println(prop.getProperty("url"));

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		login = new Login_Page(driver);
		landingpage = new LandingPage(driver);
	}
	
	@Test
	public void exceltest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		Util reader = new Util();
		int rowcount = reader.getRowCount(xlsfile, "UNP");
		System.out.println("Rowcount   "+rowcount);
		int cellcount = reader.getCellCount(xlsfile, "UNP", 2);
		System.out.println("Cellcount   "+cellcount);
		
		for(int i=1; i <= rowcount; i++) {
			
			login.selectRepo(prop.getProperty("repo"));
			login.click_Nextbtn();
			login.userName(reader.getexceldata(xlsfile, "UNP", i, 0));
			Thread.sleep(1000);
			login.password(reader.getexceldata(xlsfile, "UNP", i, 1));
			Thread.sleep(1000);
			login.click_Nextbtn();
			Thread.sleep(1000);
			String validationMsg = login.getValidationMsg();
			System.out.println(i+"   "+validationMsg);
			Thread.sleep(1000);
			landingpage.clickSignout();
			Thread.sleep(1000);
		}
	}

}
