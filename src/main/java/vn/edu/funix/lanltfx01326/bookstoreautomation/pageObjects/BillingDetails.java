package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vn.edu.funix.lanltfx01326.bookstoreautomation.helper.wait.WaitHelper;

public class BillingDetails {
	private WebDriver driver;
	
	WaitHelper waitHelper; 
	
	//BOEING LOGIN SCREEN 
	@FindBy(xpath = "//*[@id=\"accessLoginId\"]")
	public WebElement aviationId;

	@FindBy(xpath = "//*[@id=\"accessuserpassword\"]")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"LoginBtn\"]")
	WebElement loginButton;
	
	public void enterAviationId(String aviationId) {
		this.aviationId.sendKeys(aviationId);
	}
	
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	
	//SKY READY RIGHT MENU
	@FindBy(xpath="//a[@class='pl-3 d-inline-block align-middle hamburger-button']")
	public WebElement hamburger_r_AR;
		
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/div[2]/ul/li[5]/div[2]/div")
	public WebElement btn_roster_r_AR;
	

	@FindBy(xpath="//li[@title='Privacy']")
	public WebElement btn_privacy_r_AR; 


	@FindBy(xpath="//li[@title='About']")
	public WebElement btn_about_r_AR;
	

	@FindBy(xpath="//li[@title='Contact Us']")
	public WebElement btn_contact_r_AR;
	

	@FindBy(xpath="//li[@class='list-group-item row cursor-pointer' and @title='Logout']")
	public WebElement btn_logout_r_AR;
	
	public void clickHamburgerMenu() {
		hamburger_r_AR.click();
	}
	
	public String getTextHeader() {
		return lbl_search_RM.getText().trim();
	}
	
	public void clickAboutButton() {
		btn_about_r_AR.click(); 
	}
	
	
	public void clickContactUsButton() {
		btn_contact_r_AR.click();
	}
	
	
	public void clickPrivacy() {
		btn_privacy_r_AR.click();
	}
	
	
	//SKY READY LEFT MENU
	@FindBy(xpath="/html/body/app-root/app-dashboard/div[1]/div[1]/a[4]/img[2]")
	public WebElement btn_roster_l_AR;
	
	@FindBy(xpath="")
	public WebElement btn_campusInfo_l;
	
	
	
	//LOG OUT ELEMENTS
	@FindBy(xpath="//button[@class='btn btn-secondary btn-return font-weight-bold' and contains(text(),'Return')]")
	public WebElement btn_logoutconfirmation_return;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-logout font-weight-bold' and contains(text(),'Logout')]")
	public WebElement btn_logoutconfirmation_logout;
	
	@FindBy(xpath="//h4[@class='search-heading']")
	public WebElement lbl_search_RM;
	
	
	
	public BillingDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);		
	}
	
}
