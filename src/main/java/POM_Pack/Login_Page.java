package POM_Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Login_Page {

	@FindBy (xpath = "//button[@id='details-button']")
	private WebElement Advanced_btn;
	
	@FindBy (xpath = "//a[@id='proceed-link']")
	private WebElement proceedlink;
	
	@FindBy (xpath = "//select[@name='repository']")
	private WebElement Repositories;
	
	@FindBy (xpath = "//button[@class='btn btn-primary btn-block']")
	private WebElement Nextbtn;
	
	@FindBy (xpath = "(//input[@id='loginUserName'])[2]")
	private WebElement Username;
	
	@FindBy (xpath = "//input[@id='loginUserPassword']")
	private WebElement Password;
	
	@FindBy (xpath = "//button[@id='loginSubmitBtn']")
	private WebElement Signin;
	
	@FindBy (xpath = "//div[@class='hoverHeader']")
	private WebElement validationmsg;
	
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void click_Advancedbtn() {
		Advanced_btn.click();
	}
	
	public void proceedlink() {
		proceedlink.click();
	}
	
	public void selectRepo(String repo) {
		Select repodrop = new Select(Repositories);
		repodrop.selectByVisibleText(repo);
	}
	
	public void click_Nextbtn() {
		Nextbtn.click();
	}
	
	public void userName(String user) {
		Username.sendKeys(user);
	}
	
	public void password(String pass) {
		Password.sendKeys(pass);
	}
	
	public void signinBtn() {
		Signin.click();
	}
	
	public String getValidationMsg() {
		return validationmsg.getText();
	}
	
}
