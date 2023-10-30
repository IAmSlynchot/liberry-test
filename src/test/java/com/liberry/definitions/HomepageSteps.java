package com.liberry.definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageSteps extends TestSteps {

    @Before
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Given("I am logged in as an existing user")
    public void launchAndLogin(){
        this.loadHomepage();
        this.logInAsExistingUser();
    }

    @When("I navigate to the {string} page")
    public void navigateTo(String target) {
        switch (target) {
            case "HOME":
                driver.findElement(By.id("nav-left-home")).click();
                break;
            case "SETTINGS":
                driver.findElement(By.id("nav-left-settings")).click();
                break;
            case "ABOUT":
                driver.findElement(By.id("nav-left-about")).click();
                break;
            default:
                Assert.fail("Invalid page name passed to navigation step: " + target);
        }
    }


    @Then("the {string} page heading should display")
    public void verifyPageHeading(String target) {
        String pageTitle;
        switch (target) {
            case "HOME":
                pageTitle = driver.findElement(By.id("home-page-title")).getText();
                Assert.assertEquals(pageTitle, "My LiBerry");
                break;
            case "SETTINGS":
                pageTitle = driver.findElement(By.id("settings-page-title")).getText();
                Assert.assertEquals(pageTitle, "Settings");
                break;
            case "ABOUT":
                pageTitle = driver.findElement(By.id("about-page-title")).getText();
                Assert.assertEquals(pageTitle, "About");
                break;
            default:
                Assert.fail("Invalid page name passed to heading verification step: " + target);
        }
    }

    @After
    public void afterClass() {
        driver.quit();
    }
}
