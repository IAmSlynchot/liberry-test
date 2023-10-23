package com.liberry.definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import io.cucumber.java.en.*;

public class HomepageSteps {

    private WebDriver driver;

    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @When("the homepage loads")
    public void loadHomePage() {
        driver.get("http://localhost:3000/");
    }

    @Then("the page title text is visible")
    public void titleTextVisible() {
        Assert.assertEquals(driver.getTitle(), "LiBerry");
    }

    @After
    public void afterClass() {
        driver.quit();
    }
}
