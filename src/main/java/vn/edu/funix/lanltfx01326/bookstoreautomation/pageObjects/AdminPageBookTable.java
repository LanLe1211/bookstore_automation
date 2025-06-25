package vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminPageBookTable {
	private WebElement adminBookTableElement;
	
	public AdminPageBookTable(WebElement element) {
		adminBookTableElement = element;
	}
	
	public List<WebElement> getAllTableRow() {
		return adminBookTableElement.findElements(By.xpath("//tbody//tr"));
	}
	
	public static WebElement getBookNameElementFromTableRow(WebElement tableRow) {
		return tableRow.findElement(By.className("book_name"));
	}
	
	public static WebElement getBookAuthorElementFromTableRow(WebElement tableRow) {
		return tableRow.findElement(By.className("book_authors"));
	}
	
	public static WebElement getBookPublisherElementFromTableRow(WebElement tableRow) {
		return tableRow.findElement(By.className("book_publisher"));
	}
	
	public static WebElement getBookPublishDateElementFromTableRow(WebElement tableRow) {
		return tableRow.findElement(By.className("book_publish_date"));
	}
	
	public static WebElement getBookIsbnElementFromTableRow(WebElement tableRow) {
		return tableRow.findElement(By.className("book_isbn"));
	}
	
	public static WebElement getBookPriceElementFromTableRow(WebElement tableRow) {
		return tableRow.findElement(By.className("book_price"));
	}
	
	public static WebElement getBookEditElementFromTableRow(WebElement tableRow) {
		return tableRow.findElement(By.className("book_edit_btn"));
	}
	
	public static WebElement getBookDeleteElementFromTableRow(WebElement tableRow) {
		return tableRow.findElement(By.className("book_delete_btn"));
	}
}