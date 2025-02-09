package com.base;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(By location) {
        try {
            WebElement element = driver.findElement(location);
            element.click();
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    /**
     * Clicks the first WebElement from a list of elements that contains a specific text,
     * as identified by the provided locators.
     *
     * @param elementsLocator The By locator used to identify the list of elements.
     * @param textLocator The By locator used to identify the text within the elements.
     * @throws RuntimeException If no element with the specified text is found.
     * @throws Exception If there's an issue with finding the elements or clicking on them.
     */
    public void clickElementFromListContainsTextLocator(By elementsLocator, By textLocator) {
        try {
            this.driver.findElements(elementsLocator).stream()
                    .filter(e -> e.findElement(textLocator).isDisplayed())
                    .findFirst()
                    .ifPresentOrElse(
                            WebElement::click,
                            () -> { throw new RuntimeException("No element with the specified text found"); }
                    );
        } catch (Exception e) {
            System.out.println("Element not found or verification failed: " + e.getMessage());
        }
    }

    /**
     * Clicks the first WebElement from a list of elements that contains a specific text,
     * as identified by the provided locators.
     *
     * @param elementsLocator The By locator used to identify the list of elements.
     * @param textLocator The By locator used to identify the text within the elements.
     * @param text The specific text to search for within the elements.
     * @throws Exception If there's an issue with finding the elements or clicking on them.
     */
    public void clickElementFromListContainsTextLocator(By elementsLocator, By textLocator, String text) {
        try {
            this.driver.findElements(elementsLocator).stream()
                    .filter(element -> element.findElements(textLocator).stream()
                            .anyMatch(child -> child.getText().equalsIgnoreCase(text)))
                    .findFirst()
                    .ifPresent(WebElement::click);
        } catch (Exception e) {
            System.out.println("Element not found or verification failed: " + e.getMessage());
        }
    }
}
