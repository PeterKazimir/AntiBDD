package com.antibdd.steps;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.antibdd.steps.BasicSteps.*;

public class Hooks {

    @Before
    public void beforeScenario() {
        createBrowserInstance();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        embedScreenshot(scenario);
    }

    private void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}