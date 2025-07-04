package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPageBookContainer {
	private WebElement bookContainerElement;
	
	public CartPageBookContainer(WebElement bookContainerElement) {
		this.bookContainerElement = bookContainerElement;
	}
	
	public String getBookTitle() {
		return bookContainerElement.findElement(By.className("book_name")).getText();
	}
	
	public String getBookAuthor() {
		return bookContainerElement.findElement(By.className("book_author")).getText();
	}
	
	public String getBookPrice() {
		return bookContainerElement.findElement(By.className("book_price")).getText();
	}
	
	public WebElement removeFromCartButton() {
		return bookContainerElement.findElement(By.className("remove_from_cart"));
	}
}