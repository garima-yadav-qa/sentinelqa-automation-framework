package com.sentinelqa.tests;

import com.sentinelqa.core.DriverFactory;
import com.sentinelqa.pages.CheckoutPage;
import com.sentinelqa.pages.PlansPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/** End-to-end UI checks for the subscription upgrade journey. */
public class SubscriptionTest {

    private WebDriver driver;
    private PlansPage plansPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.create();
        String baseUrl = System.getProperty("baseUrl", "https://app.example.test");
        driver.get(baseUrl + "/plans");
        plansPage = new PlansPage(driver);
    }

    @Test(groups = "regression")
    public void upgradeChangesPlanAndBilling() {
        CheckoutPage checkout = plansPage.upgradeTo("pro");
        assertThat(checkout.activePlan()).isEqualTo("Pro");
        assertThat(checkout.nextInvoice()).isPositive();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
