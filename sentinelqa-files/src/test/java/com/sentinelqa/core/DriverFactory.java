package com.sentinelqa.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Creates a WebDriver based on the -Dbrowser system property.
 * Keeps driver setup in one place so tests stay clean and can run cross-browser in parallel.
 */
public final class DriverFactory {

    private DriverFactory() { }

    public static WebDriver create() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new", "--window-size=1440,900");
                return new ChromeDriver(options);
        }
    }
}
