package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registrationPage extends basePage {
	
	public registrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstname;
	
	@FindBy(id="input-lastname")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//label[@class='radio-inline']//input[@value='1']")
	private WebElement newsletter;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacypolicy;
	
	@FindBy(xpath="//input[@class=\"btn btn-primary\"]")
	private WebElement Submitbutton;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement confirmmessage;
	
	
 	public void txtFirstName(String Firstname) {
		firstname.sendKeys(Firstname);
	}
	
	
	public void txtLastName(String LastName) {
		lastname.sendKeys(LastName);
	}
	
	
	public void txtEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void telephones(String mobile) {
		telephone.sendKeys(mobile);
	}
	
	public void txtPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void txtConfirmPassword(String Cpassword) {
		confirmPassword.sendKeys(Cpassword);
	}
	
	public void chkNewsletter() {
		newsletter.click();
	}
	
	public void chkPolicy() {
		privacypolicy.click();
	}
	
	public void btnSubmit() {
		Submitbutton.click();
	}
	
	public String confirmsg() {
		String cnfrmmsg =confirmmessage.getText();
		return cnfrmmsg;
	}

}
