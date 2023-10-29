package com.liberry.definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class TestSteps {
    protected WebDriver driver;

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void enterText(String elementId, String value) {
        driver.findElement(By.id(elementId)).sendKeys(value);
    }
    
}
