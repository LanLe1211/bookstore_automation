package vn.edu.funix.lanltfx01326.bookstoreautomation.testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import vn.edu.funix.lanltfx01326.bookstoreautomation.enums.Browsers;
import vn.edu.funix.lanltfx01326.bookstoreautomation.enums.OS;
import vn.edu.funix.lanltfx01326.bookstoreautomation.helper.wait.WaitHelper;

public class TestBase {

	protected static WebDriver driver;

	protected static WaitHelper waitHelper;

	public static void initDriverForBrowser(String browser) {
		if (System.getProperty("os.name").toLowerCase().contains(OS.LINUX.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				// System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox", "--disable-extensions", "--disable-dev-shm-usage", "--headless",
						"start-maximized");
				driver = new ChromeDriver(options);

			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				// System.setProperty("webdriver.gecko.driver",
				// "src/test/resources/drivers/geckodriver");
				driver = new FirefoxDriver();
			}

		} else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				System.setProperty("webdriver.chrome.driver",
						"src/main/resources/drivers/chromedriver-mac-x64/chromedriver");
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				System.setProperty("webdriver.gecko.driver",
						"src/main/resources/drivers/geckodriver-macos/geckodriver");
				driver = new FirefoxDriver();
			}
		}

		waitHelper = new WaitHelper(driver);
	}

	public static WebDriver getCurrentWebDriver() {
		return driver;
	}

	public static WaitHelper getWaitHelper() {
		return waitHelper;
	}
	
}
