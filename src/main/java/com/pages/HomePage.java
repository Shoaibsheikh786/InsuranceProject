package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
   @FindBy(xpath="//button[text()='PropertyInsurance']")
   private WebElement propButton;
   private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{   
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPropBtn()
	{
		propButton.click();
	}
	
	public boolean verifyPage(String head)
	{
		return driver.getPageSource().contains(head);
		
		
	} 
	
	public PropertyDetailsPage getPropertyDetails()
	{
		clickOnPropBtn();
		return new PropertyDetailsPage(driver);
	}
	

	/*********************************************************************/
	/** PROPERTY DETAILS PAGE*/
	


}
