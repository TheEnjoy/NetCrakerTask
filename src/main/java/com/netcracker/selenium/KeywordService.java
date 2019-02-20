package com.netcracker.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;


import java.io.IOException;
import java.util.Properties;

public class KeywordService {

    WebDriver driver;
    WebDriverWait wait;
    Properties properties;


    public KeywordService() {
        properties = new Properties();
        try {
            properties.load(KeywordService.class.getClassLoader()
                    .getResourceAsStream("application.properties"));
        } catch (IOException e) {
            System.out.println("Properties not loaded");
            e.printStackTrace();
        }
    }

    public void openBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("gecko.path"));
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.path"));
            driver = new ChromeDriver();
        }
    }

    public void openUrl(String url) {
        driver.navigate().to(url);
    }

    private By locatorValue(String locatorType, String value) {
        By by;
        switch (locatorType) {
            case "id":
                by = By.id(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "css":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                by = null;
                break;
        }
        return by;
    }

    public void setValue(String locatorType, String value, String text) {
        By locator = locatorValue(locatorType, value);
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
        wait = new WebDriverWait(driver,40);
    }


    public void clickOnLocator(String locatorType, String value) {
        By locator = locatorValue(locatorType, value);
        WebElement element = driver.findElement(locator);
        element.click();
        //wait = new WebDriverWait(driver,2);
    }

    public void closeBrowser() {
        wait = new WebDriverWait(driver,2);
        driver.close();
    }


    public boolean checkSetValue(String locatorType, String value,String attribute,String valueToCheck){
        wait = new WebDriverWait(driver,2);
        By locator = locatorValue(locatorType, value);
        WebElement element = driver.findElement(locator);
        String elementValue = element.getAttribute(attribute);
        if(valueToCheck != null){
            return valueToCheck.equalsIgnoreCase(elementValue);
        }
        return element != null;
    }

    public boolean checkElementVisible(String locatorType, String value){
        wait = new WebDriverWait(driver,2);
        By locator = locatorValue(locatorType, value);
        Boolean isPresent = driver.findElements(locator).size() > 0;
        return isPresent;
    }

    public void takeSnapShot(String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File destFile=new File(fileWithPath);
        FileUtils.copyFile(srcFile, destFile);

    }

}

