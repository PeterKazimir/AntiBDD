package com.antibdd.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Stepdefs {

    static WebDriver driver;
    static Map<String, String> objects = new HashMap<String, String>();

    @Given("^use (.+)$")
    public static void getObjects(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line = "";
        while ((line = in.readLine()) != null) {
            String parts[] = line.split("===");
            objects.put(parts[0].trim(), parts[1].trim());
        }
        in.close();
    }

    @When("^go to (.+)")
    public static void goToUrl(String url) {
        driver.get(url);
    }

    @And("^enter text (.+) to (.+)$")
    public static void andEnterText(String textToEnter, String locator) {
        enterText(textToEnter, locator);
    }

    @And("^click element (.+)$")
    public static void andClick(String locator) {
        clickElement(locator);
    }

    @And("^click first element (.+)$")
    public static void andClickFirst(String locator) {
        clickFirstElement(locator);
    }

    @And("^wait (\\d+)$")
    public static void andWait(int time) {
        waitForTime(time);
    }

    @Then("^element (.+) contains text (.+)$")
    public static void thenElementHasText(String locator, String textToFind) {
        verifyElementHasText(locator, textToFind);
    }

    @Then("^element (.+) is displayed$")
    public static void thenElementIsDisplayed(String locator) {
        verifyElementIsDisplayed(locator);
    }

    @Before
    public void beforeScenario() {
        driver = new ChromeDriver();
    }

    @After
    public void afterScenario() {
        driver.quit();
    }

    public static void waitForTime(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementIsDisplayed(String locator) {
        String locatorFromObjects = objects.get(locator);
        if(!StringUtils.isBlank(locatorFromObjects)){
            Assert.assertTrue(driver.findElement(getBy(locatorFromObjects)).isDisplayed());
        } else {
            Assert.assertTrue(driver.findElement(getBy(locator)).isDisplayed());
        }
    }

    public static void verifyElementHasText(String locator, String textToFind) {
        String locatorFromObjects = objects.get(locator);
        if(!StringUtils.isBlank(locatorFromObjects)){
            Assert.assertTrue(driver.findElement(getBy(locatorFromObjects)).getText().contains(textToFind));
        } else {
            Assert.assertTrue(driver.findElement(getBy(locator)).getText().contains(textToFind));
        }
    }

    private static void enterText(String textToEnter, String locator) {
        String locatorFromObjects = objects.get(locator);
        if(!StringUtils.isBlank(locatorFromObjects)){
            driver.findElement(getBy(locatorFromObjects)).sendKeys(textToEnter);
        } else {
            driver.findElement(getBy(locator)).sendKeys(textToEnter);
        }
    }

    public static void clickFirstElement(String locator) {
        String locatorFromObjects = objects.get(locator);
        if(!StringUtils.isBlank(locatorFromObjects)){
            driver.findElements(getBy(locatorFromObjects)).get(0).click();
        } else {
            driver.findElements(getBy(locator)).get(0).click();
        }
    }

    public static void clickElement(String locator) {
        String locatorFromObjects = objects.get(locator);
        if(StringUtils.isBlank(locatorFromObjects)){
            driver.findElement(getBy(locator)).click();
        } else {
            driver.findElement(getBy(locatorFromObjects)).click();
        }
    }

    public static By getBy(String locator) {
        By by = null;
        if(locator.startsWith("xpath")) {
            locator = locator.replace("xpath=", "");
            by = By.xpath(locator);
        }
        if(locator.startsWith("css")) {
            locator = locator.replace("css=", "");
            by = By.cssSelector(locator);
        }
        if(locator.startsWith("id")) {
            locator = locator.replace("id=", "");
            by = By.id(locator);
        }
        return by;
    }

    /*
    public static void doSomething() {
        driver.findElement();

        driver.findElement().getText();
        driver.findElement().isDisplayed();
        driver.findElement().sendKeys();

        driver.findElements();
        driver.findElements().size();

        driver.getTitle();
        driver.getPageSource();

        driver.switchTo().frame();
        driver.switchTo().window();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();

        driver.get();
        driver.navigate().back();
        driver.navigate().refresh();
    }
    */
}