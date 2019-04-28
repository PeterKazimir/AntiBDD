package com.antibdd.steps;

import cucumber.api.java.Before;

public class Hooks extends BasicSteps {

    @Before
    public void beforeScenario() {
        createBrowserInstance();
    }
}