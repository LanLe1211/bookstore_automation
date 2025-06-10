package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageBookContainer {
	private WebElement bookContainerElement;
	
	public HomePageBookContainer(WebElement bookContainerElement) {
		this.bookContainerElement = bookContainerElement;
	}
	
	public String getBookTitle() {
		return bookContainerElement.findElement(By.xpath("//h5[contains(@class, 'book_title')]")).getText();
	}
	
	public String getBookAuthor() {
		return bookContainerElement.findElement(By.xpath("//*[contains(@class, 'book_author')]")).getText();
	}
	
	public String getBookPublisher() {
		return bookContainerElement.findElement(By.xpath("//*[contains(@class, 'book_publisher')]")).getText();
	}
	
	public String getBookPublishedDate() {
		return bookContainerElement.findElement(By.xpath("//*[contains(@class, 'book_published_date')]")).getText();
	}
	
	public String getBookIsbn() {
		return bookContainerElement.findElement(By.xpath("//*[contains(@class, 'book_isbn')]")).getText();
	}
	
	public String getBookPrice() {
		return bookContainerElement.findElement(By.xpath("//*[contains(@class, 'book_price')]")).getText();
	}
	
	public WebElement addToCartButton() {
		return bookContainerElement.findElement(By.xpath("//*[contains(@class, 'book_add_to_cart')]"));
	}
}