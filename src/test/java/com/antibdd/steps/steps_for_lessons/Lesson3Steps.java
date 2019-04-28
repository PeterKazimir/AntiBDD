package com.antibdd.steps.steps_for_lessons;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Lesson3Steps {
    @When("user performs Google search of phrase (.+)")
    public void userPerformsGoogleSearchOfPhrase(String phrase) {

    }

    @Then("phrase (.+) is shown in results")
    public void phraseIsShownInResults(String phrase) {

    }
}
