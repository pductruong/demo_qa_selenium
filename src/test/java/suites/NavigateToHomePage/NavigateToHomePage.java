package suites.NavigateToHomePage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.utils.ConfigReader;
import com.pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigateToHomePage {

    WebDriver driver;
    HomePage homePage;

    @BeforeEach
    public void setUp() {
        ConfigReader configReader = new ConfigReader();
        String browser = configReader.getProperty("browser");
        String chromeDriverPath = configReader.getProperty("chrome.driver.path");
        String chromeBinaryPath = configReader.getProperty("chrome.binary.path");

        if ("chrome".equalsIgnoreCase(browser)) {
            // Set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            // Create ChromeOptions to specify Chrome binary
            ChromeOptions options = new ChromeOptions();
            options.setBinary(chromeBinaryPath);

            // Initialize ChromeDriver with specified Chrome version
            driver = new ChromeDriver(options);
            homePage = new HomePage(driver);
        } else {
            throw new IllegalArgumentException("Unsupported browser type: " + browser);
        }
    }

    @Test
    public void testNavigateToHomePage() throws InterruptedException {
        homePage.openHomePage();
        homePage.clickElementsTopic();
        Thread.sleep(3000);

        // Verify the page title
//        String expectedTitle = "Google";
//        String actualTitle = driver.getTitle();
//        assertEquals(expectedTitle, actualTitle, "Page title does not match!");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }

    }
}
