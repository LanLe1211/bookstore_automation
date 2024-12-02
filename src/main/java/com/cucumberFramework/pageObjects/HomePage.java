package com.cucumberFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@name=\"term\"]")
	WebElement searchInput;

	@FindBy(xpath = "//form[@action='/search']/button[@type=\"submit\"]")
	WebElement searchButton;

	@FindBy(xpath = "//div[contains(@class, 'card text')]")
	List<WebElement> displayList;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterSearchText(String term) {
		this.searchInput.sendKeys(term);
	}

	public void submitSearch() {
		this.searchButton.click();
	}
	
	public List<WebElement> getDisplayItems() {
		return displayList;
	}
	
	public String getTitleLocator() {
		return "//a[@class=\"navbar-brand\"]";
	}
}
