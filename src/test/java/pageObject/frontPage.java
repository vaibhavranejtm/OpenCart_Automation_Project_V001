package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class frontPage extends basePage {
	
	public frontPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//li[1]//a[1]")
	private WebElement Register;
	
	@FindBy(xpath="//li//a[normalize-space()=\"Login\"]")
	private WebElement login;
	
	
	public void clkMyAccount() {
		myAccount.click();
	}
	
	public void clkRegister() {
		Register.click();
	}
	
	public void clkLogin() {
		login.click();
	}
	

}
