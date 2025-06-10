package vn.edu.funix.lanltfx01326.bookstoreautomation.stepDefinitions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.HomePageBookContainer;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.BookDetailsPage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.pageObjects.HomePage;
import vn.edu.funix.lanltfx01326.bookstoreautomation.testBase.TestBase;

public class HomePageStepsDefinition extends TestBase {
	private static Logger logger = LogManager.getLogger(HomePageStepsDefinition.class);
	private HomePage homePage;
	//UI check
	
	
	//BookList
	@Given("User is on bookstore homepage {string}")
	public void user_is_on_home_page(String string) {
		WebDriver driver = getCurrentWebDriver();
		driver.get(string);
		homePage = new HomePage(driver);
		waitHelper.WaitForElementLocatorVisible(homePage.getTitleLocator(), 10, 100);
	}
	
	@Then("homepage title is {string}")
	public void home_page_title_is(String string) {
		WebDriver driver = getCurrentWebDriver();
		waitHelper.setImplicitWait(Duration.ofSeconds(2));
		WebElement pageTitle = driver.findElement(By.xpath(homePage.getTitleLocator()));
		Assert.assertEquals(string, pageTitle.getText()); 
	}
	
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
	
	
	//Search books
	@When("I enter keyword as {string}")
	public void i_enter_keyword_as(String string) {
		homePage.enterSearchText(string);
		homePage.submitSearch();
	}
	
	@Then ("I see the number of results as {int}")
	public void i_see_the_number_of_results_as(int resultcount) {
		waitHelper.setImplicitWait(Duration.ofSeconds(2));
		List<HomePageBookContainer> bookContainerList = homePage.getBookContainerList();
		Assert.assertEquals(bookContainerList.size(), resultcount);
	}

	@Then("I see search result contain {string}")
	public void i_see_search_result_contain_string(String titleListString) throws InterruptedException {
		waitHelper.setImplicitWait(Duration.ofSeconds(2));
		List<String> titleList = Arrays.asList(titleListString.split("\\s*,\\s*"));
		List<HomePageBookContainer> bookContainerList = homePage.getBookContainerList();
		for(HomePageBookContainer book:bookContainerList) {
			Assert.assertListContainsObject(titleList, book.getBookTitle(), null);
		}
	}
	
	// Navigate link
	@When("user click on the admin link")
	public void user_click_on_the_admin_link() {
		homePage.navigateToAdminPage();
		waitHelper.setImplicitWait(Duration.ofSeconds(10));
	}
}
