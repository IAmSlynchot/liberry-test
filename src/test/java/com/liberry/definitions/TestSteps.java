package com.liberry.definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class TestSteps {
    protected WebDriver driver;
    protected static final Logger log = LogManager.getLogger(TestSteps.class);


    protected void initializeWebDriver() {
        log.info("Initializing webdriver...");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/ChromeDriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    protected void loadHomepage() {    
        driver.get("http://localhost:3000/");
    }

    protected void logInAsExistingUser() {
        driver.findElement(By.id("amplify-id-:r4:")).sendKeys("sam");
        driver.findElement(By.id("amplify-id-:r7:")).sendKeys("123testing");
        driver.findElement(By.className("amplify-button--primary")).click();
    }

    protected void enterText(String elementId, String value) {
        driver.findElement(By.id(elementId)).sendKeys(value);
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isTextPresent(String textToLocate) {
        return isElementPresent(By.xpath ("//*[contains(text(),'" + textToLocate + "')]"));
    }
}
