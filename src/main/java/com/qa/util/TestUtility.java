package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtility {
	  // Method to open a web page
    public static void openPage(WebDriver driver, String url) {
        driver.get(url);
    }

    // Method to find an element by a given selector
    public static WebElement findElement(WebDriver driver, By selector) {
        return driver.findElement(selector);
    }

    // Method to click on an element
    public static void clickElement(WebElement element) {
        element.click();
    }

    // Method to input text into a text field
    public static void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    // Method to input text into a text field By Xpath
    public static void enterTextWithBy(WebDriver driver,By ele,String text) {
      driver.findElement(ele).sendKeys(text);
    
    }
    // Method to get text from an element
    public static String getText(WebElement element) {
        return element.getText();
    }

}
