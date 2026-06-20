package com.sentinelqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** Page object for the checkout / confirmation page after a plan change. */
public class CheckoutPage {

    private final WebDriver driver;
    private final By activePlan = By.cssSelector("[data-test=plan]");
    private final By nextInvoice = By.cssSelector("[data-test=next-invoice]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String activePlan() {
        return driver.findElement(activePlan).getText();
    }

    public double nextInvoice() {
        String raw = driver.findElement(nextInvoice).getText().replaceAll("[^0-9.]", "");
        return Double.parseDouble(raw);
    }
}
