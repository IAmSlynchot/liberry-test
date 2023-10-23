package com.liberry.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/Homepage.feature"}, glue = {"com.liberry.definitions"}, plugin = {})
public class RunCucumberTest extends AbstractTestNGCucumberTests{
}
