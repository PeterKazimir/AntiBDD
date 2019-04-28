package com.antibdd.steps;

import com.antibdd.steps.actions.BasicActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

public class StepDefs extends BasicActions {

    @Given("^use (.+)$")
    public void getObjects(String fileName) throws IOException {
        addObjectsFromFile(fileName);
    }

    @When("^user navigates to (.+)")
    public void goToUrl(String url) {
        navigateToUrl(url);
    }

    @And("^enters text (.+) to (.+)$")
    public void andEnterText(String textToEnter, String locator) {
        enterText(textToEnter, locator);
    }

    @And("^clicks element (.+)$")
    public void andClick(String locator) {
        clickElement(locator);
    }

    @And("^clicks first element (.+)$")
    public void andClickFirst(String locator) {
        clickFirstElement(locator);
    }

    @And("^waits (\\d+) seconds$")
    public void andWait(int time) {
        waitForTime(time);
    }

    @Then("^element (.+) contains text (.+)$")
    public void thenElementHasText(String locator, String textToFind) {
        verifyElementHasText(locator, textToFind);
    }

    @Then("^element (.+) is displayed$")
    public void thenElementIsDisplayed(String locator) {
        verifyElementIsDisplayed(locator);
    }
}