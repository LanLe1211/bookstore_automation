package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vn.edu.funix.lanltfx01326.bookstoreautomation.helper.wait.WaitHelper;

public class AdminLoginPage {
	private WebDriver driver;

	@FindBy(id = "username")
	 WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login_submit")
	WebElement loginButton;
	
	private String validatorMessageLocator="//form[@action='/login']//em";
	
	
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		this.username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public String getMessage() {	
		WebElement messageElement = driver.findElement(By.xpath(validatorMessageLocator));	
		return messageElement.getText();		
	}
}
