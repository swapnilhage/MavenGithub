package Base_Pack;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base_Class {

	WebDriver driver;
	static FileInputStream propfile;
	static Properties prop;
	
	public static WebDriver openChromeBrowser() {
			
		System.setProperty("webdriver.chrome.driver", "D:\\Swapnil\\SH\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow.origins=*");
		WebDriver driver = new ChromeDriver(co);
		return driver;
	}
	
public static Properties property() {
		
		try {
			prop = new Properties();
			propfile = new FileInputStream("C:\\Users\\SwapnilHage\\eclipse-workspace\\Maven\\src\\main\\java\\config.properties");
			prop.load(propfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}
