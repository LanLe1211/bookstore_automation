package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vn.edu.funix.lanltfx01326.bookstoreautomation.helper.wait.WaitHelper;

public class BookFormPage {

	private WebDriver driver;
	private WaitHelper waitHelper;

	public BookFormPage(WebDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "book_name")
	WebElement newBookNameInputElement;

	@FindBy(id = "book_price")
	WebElement newBookPriceInputElement;

	@FindBy(id = "book_author")
	WebElement newBookAuthorInputElement;

	@FindBy(id = "book_isbn")
	WebElement newBookISBNInputElement;

	@FindBy(id = "book_publisher")
	WebElement newBookPublisherInputElement;

	@FindBy(id = "book_published_date")
	WebElement newBookPublishedDateInputElement;

	@FindBy(id = "book_form_submit")
	WebElement newBookFormSubmitButtonElement;

	public void filNewBookForm(String bookname, String price, String author, String isbn, String publisher, String date) {
 		newBookNameInputElement.clear();
		newBookNameInputElement.sendKeys(bookname);
		newBookPriceInputElement.clear();
		newBookPriceInputElement.sendKeys(price);
		newBookAuthorInputElement.clear();
		newBookAuthorInputElement.sendKeys(author);
		newBookISBNInputElement.clear();
		newBookISBNInputElement.sendKeys(isbn);
		newBookPublisherInputElement.clear();
		newBookPublisherInputElement.sendKeys(publisher);
		newBookPublishedDateInputElement.clear();
		newBookPublishedDateInputElement.sendKeys(date);
	}
	
	
	public void clickSaveNewBookButton() {
		newBookFormSubmitButtonElement.click();
	}

	public String getAddNewBookErrorMsg(String id) {
		waitHelper.WaitForElementVisibleById(id, 5, 100);
		WebElement addNewBookErrorMsg = driver.findElement(By.id(id));
		return addNewBookErrorMsg.getText();
	}
}
