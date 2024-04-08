package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			tDriver.set(new ChromeDriver());

		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			tDriver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			//tDriver.set(new MSEdgeDriver());
		}
		else
		{
			System.out.println("Browser not found "+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tDriver.get();
	}

}
