package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class logInPage extends basePage {
	public logInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	private WebElement userEmail;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	private WebElement userPassword;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement buttonLogIn;
	
	
	public void userName(String email) {
		userEmail.sendKeys(email);
	}
	
	public void Passwords(String password) {
		userPassword.sendKeys(password);
	}
	
	
	public void buttonSubmit() {
		buttonLogIn.click();
	}
	
	
	

}
