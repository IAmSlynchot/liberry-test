package com.liberry.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    tags = "@e2e", 
    features = {"src/test/resources/features"}, 
    glue = {"com.liberry.definitions"},
    plugin = { "pretty", "html:target/cucumber-reports" },
	monochrome = true
)
public class RunCucumberTest extends AbstractTestNGCucumberTests{
}
