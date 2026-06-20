package com.sentinelqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page object for the subscription plans page.
 * Locators live here, not in the tests.
 */
public class PlansPage {

    private final WebDriver driver;
    private final By upgradeBtn = By.cssSelector("[data-test=upgrade]");

    public PlansPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutPage upgradeTo(String plan) {
        driver.findElement(By.id(plan)).click();
        driver.findElement(upgradeBtn).click();
        return new CheckoutPage(driver);
    }
}
