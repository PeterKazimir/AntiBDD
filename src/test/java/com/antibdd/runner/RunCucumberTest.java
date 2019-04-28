package com.antibdd.runner;

import com.antibdd.driver.DriverInstance;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty"},
        tags = {"@execute"},
        glue={"com.antibdd.steps"}
)
public class RunCucumberTest {

    @AfterClass
    public static void tearDown() {
        DriverInstance.getInstance().getDriver().quit();
    }

}