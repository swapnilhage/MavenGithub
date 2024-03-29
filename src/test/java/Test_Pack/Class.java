package Test_Pack;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base_Pack.Base_Class;
import POM_Pack.POMClass;

public class Class extends Base_Class {

	WebDriver driver;
	Properties prop;
	POMClass drop;
	
	@Test
	public void testDropdown() {
		driver = openChromeBrowser();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		prop=property();
		driver.get(prop.getProperty("url"));
		
		POMClass drop = new POMClass(driver);
		drop.click_Advancedbtn();
		drop.proceedlink();
		drop.selectRepo();
		drop.click_Nextbtn();
		
	}
}
