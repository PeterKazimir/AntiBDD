package com.antibdd.steps.actions;

import com.antibdd.driver.DriverInstance;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BasicActions {

    public static WebDriver driver;
    private final Map<String, String> objects = new HashMap<>();

    public BasicActions(){
        createBrowserInstance();
    }

    public static void createBrowserInstance() {
        driver = DriverInstance.getInstance().getDriver();
    }

    public void addObjectsFromFile(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(
                new FileReader(
                        BasicActions.class.getResource(fileName.startsWith("/") ? fileName : "/" + fileName)
                        .getPath()
                )
        );
        String line;
        while ((line = in.readLine()) != null) {
            String[] parts = line.split("===");
            objects.put(parts[0].trim(), parts[1].trim());
        }
        in.close();
    }

    public void navigateToUrl(String url) {
        if(!url.startsWith("http")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void verifyElementIsDisplayed(String locator) {
        String locatorFromObjects = objects.get(locator);
        if(!StringUtils.isBlank(locatorFromObjects)){
            Assert.assertTrue(driver.findElement(getBy(locatorFromObjects)).isDisplayed());
        } else {
            Assert.assertTrue(driver.findElement(getBy(locator)).isDisplayed());
        }
    }

    public void verifyElementHasText(String locator, String textToFind) {
        String locatorFromObjects = objects.get(locator);
        if(!StringUtils.isBlank(locatorFromObjects)){
            Assert.assertTrue(
                    driver.findElement(getBy(locatorFromObjects))
                            .getText().toLowerCase()
                            .contains(textToFind.toLowerCase())
            );
        } else {
            Assert.assertTrue(
                    driver.findElement(getBy(locator))
                            .getText().toLowerCase()
                            .contains(textToFind.toLowerCase())
            );
        }
    }

    public void enterText(String textToEnter, String locator) {
        String locatorFromObjects = objects.get(locator);
        if(!StringUtils.isBlank(locatorFromObjects)){
            driver.findElement(getBy(locatorFromObjects)).sendKeys(textToEnter);
        } else {
            driver.findElement(getBy(locator)).sendKeys(textToEnter);
        }
    }

    public void clickFirstElement(String locator) {
        String locatorFromObjects = objects.get(locator);
        if(!StringUtils.isBlank(locatorFromObjects)){
            driver.findElements(getBy(locatorFromObjects)).get(0).click();
        } else {
            driver.findElements(getBy(locator)).get(0).click();
        }
    }

    public void clickElement(String locator) {
        String locatorFromObjects = objects.get(locator);
        if(StringUtils.isBlank(locatorFromObjects)){
            driver.findElement(getBy(locator)).click();
        } else {
            driver.findElement(getBy(locatorFromObjects)).click();
        }
    }

    private By getBy(String locator) {
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

    public void waitForTime(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}