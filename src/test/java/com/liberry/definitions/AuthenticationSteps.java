package com.liberry.definitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationSteps extends TestSteps {
    
    @Before
    public void beforeClass() {
        initializeWebDriver();
    }

    @When("I open the application")
    public void openApplication() {
        loadHomepage();
    }

    @When("I log in as an existing user")
    public void logInAsExisting() {
        logInAsExistingUser();
    }

    @When("I click the sign out button")
    public void signOut() {
        driver.findElement(By.id("nav-left-signOut")).click();
    }

    @Then("the main brand header should display")
    public void brandHeaderVisible() {
        Assert.assertTrue(isElementPresent(By.id("brand-header-logo")));
        String headerText = driver.findElement(By.id("brand-header-title")).getText();
        Assert.assertEquals(headerText, "LiBerry");
    }

    @Then("the page title text should be present")
    public void titleTextVisible() {
        Assert.assertEquals(driver.getTitle(), "LiBerry");
    }

    @Then("I should be on the login screen")
    public void verifyLoginPage() {
        Assert.assertTrue(isElementPresent(By.id("amplify-id-:rd:")));
    }

    @After
    public void afterClass() {
        driver.quit();
    }
}
