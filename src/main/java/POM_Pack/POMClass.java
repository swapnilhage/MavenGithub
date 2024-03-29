package POM_Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POMClass {
	
	@FindBy (xpath = "//button[@id='details-button']")
	private WebElement Advanced_btn;
	
	@FindBy (xpath = "//a[@id='proceed-link']")
	private WebElement proceedlink;
	
	@FindBy (xpath = "//select[@name='repository']")
	private WebElement Repositories;
	
	@FindBy (xpath = "//button[@class='btn btn-primary btn-block']")
	private WebElement Nextbtn;
	
	public POMClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void click_Advancedbtn() {
		Advanced_btn.click();
	}
	
	public void proceedlink() {
		proceedlink.click();
	}
	
	public void selectRepo() {
		Select repo = new Select(Repositories);
		repo.selectByVisibleText("icedq_1750_pg15_qa");
	}
	
	public void click_Nextbtn() {
		Nextbtn.click();
	}

}
