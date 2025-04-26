package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.enums.Browsers;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.BookDetailsPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.HomePage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class BooksListStepsDefinition extends TestBase {
	private static Logger logger = LogManager.getLogger(BooksListStepsDefinition.class);
	private HomePage homePage = new HomePage(driver);
	
	@Given("User is on bookstore homepage {string}")
	public void user_is_on_home_page(String string) {
		WebDriver driver = getCurrentWebDriver();
		driver.get(string);
		waitHelper.WaitForElementLocatorVisible(homePage.getTitleLocator(), 10, 100);

	}
	
//	@When("User is on bookstore homepage {string}")
//	public void user_is_on_home_page(String string) {
//		WebDriver driver = getCurrentWebDriver();
//		driver.get(string);
//		waitHelper.WaitForElementLocatorVisible(homePage.getTitleLocator(), 10, 100);
//	}
	
	@Then("I verify the HTML table contains the following values")
    public void i_verify_the_html_table_contains_books(DataTable dataTable) {
		WebDriver driver = this.getCurrentWebDriver();
		BookDetailsPage booktable = new BookDetailsPage(driver);
		verifyHtmlTableData(dataTable);
    }
	
	public void verifyHtmlTableData(DataTable dataTable) {
		WebDriver driver = this.getCurrentWebDriver();
        WebElement htmlTableElement = driver.findElement(By.id("")); //get the table WebElement
        List<WebElement> rowElements = htmlTableElement.findElements(By.xpath(".//tr")); //get all of the row WebElements from the table
        rowElements.remove(0); //remove the "header" row from the list of row WebElements

        List<List<String>> dataTableRows = dataTable.asLists(); //outer List<> is rows, inner List<> is cells
        for (List<String> row : dataTableRows) { //loop through every row in the DataTable input
            int rowIdx = dataTableRows.indexOf(row);
            WebElement rowElem = rowElements.get(rowIdx); //get the row WebElement based on the index of the current row in the DataTable
            List<WebElement> cellElements = rowElem.findElements(By.xpath(".//td")); //get all of the cells from the row WebElement

            for (String expectedCell : row) { //loop through every cell in the current DataTable row
                int cellIdx = row.indexOf(expectedCell);
                String actualCell = cellElements.get(cellIdx).getText();

                /*
                System.out.println for demonstration purposes
                 */
                System.out.println("DataTable row " + rowIdx + ", cell " + cellIdx + ": " + expectedCell);
                System.out.println("Actual value on the page: " + actualCell);

                Assert.assertEquals("Expected value of cell should match actual value of cell",
                        expectedCell, actualCell);
            }
        }
	}
//	@Before
//	public void initializeTest() {
//		this.initDriverForBrowser(Browsers.CHROME.name());
//	}
//	
//	@After
//	public void endTest() {   
//		this.getCurrentWebDriver().quit();
//	}
}
