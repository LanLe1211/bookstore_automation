package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPageBookContainer {
	private WebElement bookContainerElement;
	
	public CartPageBookContainer(WebElement bookContainerElement) {
		this.bookContainerElement = bookContainerElement;
	}
	
	public String getBookTitle() {
		return bookContainerElement.findElement(By.xpath("//h5[contains(@class, 'book_title')]")).getText();
	}
	
	public String getBookAuthor() {
		return bookContainerElement.findElement(By.xpath("//*[contains(@class, 'book_author')]")).getText();
	}
	
	public String getBookPrice() {
		return bookContainerElement.findElement(By.xpath("//*[contains(@class, 'book_price')]")).getText();
	}
	
	public WebElement removeFromCartButton() {
		return bookContainerElement.findElement(By.xpath("//*[contains(@class, 'remove_from_cart')]"));
	}
}