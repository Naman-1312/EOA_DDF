package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "UserName")
	private WebElement userNameField;
	@FindBy(id = "Password")
	private WebElement passwordField;
	@FindBy(id = "LoginButton")
	private WebElement loginbtn;
	
	public void enterUsername(String userName){
		userNameField.sendKeys(userName);
	}
	public void enterPassword(String password){
		passwordField.sendKeys(password);
	}
	public void loginClick(){
		loginbtn.click();
	}
	
}
