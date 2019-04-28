package com.antibdd.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInstance {

    private static DriverInstance driverInstance = null;
    private WebDriver driver;

    private DriverInstance() {
        setDriver(new ChromeDriver());
    }

    public static DriverInstance getInstance()
    {
        if (driverInstance == null)
            driverInstance = new DriverInstance();
        return driverInstance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}