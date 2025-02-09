package com.pages;

import org.openqa.selenium.WebDriver;
import com.locators.HomePageLocator;
import org.openqa.selenium.WebElement;
import com.base.BasePage;

import java.util.List;


public class HomePage extends BasePage {
    private String homePageURL = "https://demoqa.com/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(homePageURL);
    }

    // Page Object for Home Page
    // Define methods to interact with elements on the Home Page

    public void clickElementsTopic() {
        clickElementFromListContainsTextLocator(HomePageLocator.TOPIC_ITEMS_LOCATOR.getLocator(),
                HomePageLocator.TOPIC_ITEMS_LOCATOR.getLocator(),
                HomePageItems.ELEMENTS.getTitle());

    }
}

enum HomePageItems {
    ELEMENTS("Elements"),
    FORMS("Forms"),
    ALERT_FRAME_AND_WINDOWS("Alert, Frame & Windows"),
    WIDGETS("Widgets"),
    INTERACTIONS("Interactions"),
    BOOK_STORE_APPLICATION("Book Store Application");

    private final String title;

    HomePageItems(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}