package com.locators;

import org.openqa.selenium.By;

public enum HomePageLocator {
    TOPIC_ITEMS_LOCATOR(By.xpath("//div[@class=\"card mt-4 top-card\"]")),
    TOPIC_ITEMS_TEXT_LOCATOR(By.xpath("//div[@class=\"card mt-4 top-card\"]//h5"));

    private final By locator;

    HomePageLocator(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
}
