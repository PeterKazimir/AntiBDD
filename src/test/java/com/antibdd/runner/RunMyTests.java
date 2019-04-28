package com.antibdd.runner;

import com.antibdd.driver.DriverInstance;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "json:target/cucumber-report/cucumber.json"},
        tags = {"@execute"},
        glue={"com.antibdd.steps"}
)
public class RunMyTests {

    @AfterClass
    public static void tearDown() {
        DriverInstance.getInstance().getDriver().quit();
    }

}