package org.example;

import com.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleTestTestNG {
    private WebDriver driver;

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
        } else {
            throw new IllegalArgumentException("Unsupported browser type: " + browser);
        }
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
