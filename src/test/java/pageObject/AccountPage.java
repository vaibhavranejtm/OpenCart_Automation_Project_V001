package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends basePage {
	
	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()=\"My Account\"]")
	private WebElement myAccount;
	
	@FindBy(xpath="//div[@class=\"list-group\"]//a[normalize-space()=\"Logout\"]")
	private WebElement clkLogout;
	
	public boolean AccountMy() {
		try {
		return (myAccount.isDisplayed());
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void buttonLogout() {
		clkLogout.click();
	}
	}
