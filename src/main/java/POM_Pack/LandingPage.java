package POM_Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	@FindBy (xpath = "//a[@id='ice_thumbIauditBtn']")
	private WebElement iaudit;
	
	@FindBy (xpath = "//a[@id='ice_thumbAdminBtn']")
	private WebElement administration;
	
	@FindBy (xpath = "//a[@id='ice_thumbRuleMonitorBtn']")
	private WebElement ruleMonitor;
	
	@FindBy (xpath = "//a[@id='ice_thumbSchedulerBtn']")
	private WebElement scheduler;
	
	@FindBy (xpath = "(//a[@id='ice_thumbHomeBtn'])[1]")
	private WebElement dashboard;
	
	@FindBy (xpath = "(//a[@id='ice_thumbHomeBtn'])[2]")
	private WebElement testlab;
	
	@FindBy (xpath = "//a[@id='ice_thumbLogOutBtn']")
	private WebElement signout;
	
	@FindBy (xpath = "//landingpage//div[@class='hoverHeader']")
	private WebElement validationmsg;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickIaudit() {
		iaudit.click();
	}
	
	public void clickAdministration() {
		administration.click();
	}
	
	public void clickRuleMonitor() {
		ruleMonitor.click();
	}
	
	public void clickScheduler() {
		scheduler.click();
	}
	
	public void clickDashboard() {
		dashboard.click();
	}
	
	public void clickTestlab() {
		testlab.click();
	}
	
	public void clickSignout() {
		signout.click();
	}
	
	public String getValidationMsg() {
		return validationmsg.getText();
	}
	
}
