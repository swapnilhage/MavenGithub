package POM_Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Users {

	@FindBy (xpath = "//button[@type='button']")
	private WebElement newBtn;
	
	@FindBy (xpath = "(//a[@id='ice_ncbAddUser'])[1]")
	private WebElement user;
	
	@FindBy (xpath = "//input[@id='ice_addUserUserNameTxtBox']")
	private WebElement userid;
	
	@FindBy (xpath = "//input[@id='ice_addUserUserPassTxtBox']")
	private WebElement password;
	
	@FindBy (xpath = "//input[@id='ice_addUserConfPassTxtBox']")
	private WebElement confirmpassword;
	
	@FindBy (xpath = "//input[@id='ice_addUserUserFNameTxtBox']")
	private WebElement firstname;
	
	@FindBy (xpath = "//input[@id='ice_addUserUserLNameTxtBox']")
	private WebElement lastname;
	
	@FindBy (xpath = "//input[@id='ice_addUserUserFullNameTxtBox']")
	private WebElement displayname;
	
	@FindBy (xpath = "//input[@id='ice_addUserUserEmailTxtBox']")
	private WebElement email;
	
	@FindBy (xpath = "//textarea[@id='ice_addUserUserDescTxtArea']")
	private WebElement description;
	
	@FindBy (xpath = "//div[@class='slider round']")
	private WebElement adminToggleBtn;
	
	@FindBy (xpath = "//button[@id='ice_addUserSubmitBtn']")
	private WebElement saveBtn;
	
	@FindBy (xpath = "//user//div[@class='hoverHeader']")
	private WebElement validationmsg;
	
	public Admin_Users(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void newButton() {
		newBtn.click();
	}
	
	public void userOption() {
		user.click();
	}
	
	public void enterUserId(String username) {
		userid.sendKeys(username);
	}
	
	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void enterConfirmPassword(String confpassword) {
		confirmpassword.sendKeys(confpassword);
	}
	
	public void enterFirstName(String Firstname) {
		firstname.sendKeys(Firstname);
	}
	
	public void enterLastName(String Lastname) {
		lastname.sendKeys(Lastname);
	}
	
	public void enterDisplayName(String DisplayName) {
		displayname.sendKeys(DisplayName);
	}
	
	public void enterEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void enterDescription(String Description) {
		description.sendKeys(Description);
	}
	
	public void clickAdminToggleBtn() {
		adminToggleBtn.click();
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
	public String getValidationMsg() {
		return validationmsg.getText();
	}
}
