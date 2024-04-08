package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;
import com.qa.util.DataGenerator;
import com.qa.util.Dd;

public class PropertyDetailsPage {
	
	private WebDriver driver;
	private Faker faker;
	@FindBy(xpath="//select[@id='age']")
	private WebElement ageOfBuild;
	private DataGenerator dg;
	
	@FindBy(xpath="//select[@id='security']")
	private WebElement security;

    @FindBy(xpath="//input[@name='marketValue']")
    private WebElement marketValue;
    
    @FindBy(xpath="//input[@name='squareFeet']")
    private WebElement carpetValue;
    
    @FindBy(xpath="//input[@name='pincode']")
    private WebElement pincode;
    
    @FindBy(name="effected")
    private WebElement propertyEff;
    
    @FindBy(name="person")
    private WebElement salariedPerson;
    
    @FindBy(xpath="//button[normalize-space(text())='Proceed']")
    private WebElement proceed;
    
    
    
    
	
	PropertyDetailsPage(WebDriver driver)
	{  
		this.driver=driver;
		dg=new DataGenerator();
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAgeOfBuild()
	{
		ageOfBuild.click();
	}
	
	public int countOptions()
	{
		int options=Dd.countDropdownOptions(ageOfBuild);
		return options;
	}
	public boolean checkOptionAvailable(String option)
	{
		return Dd.isOptionPresent(ageOfBuild, option);
		
	}
	
	public void clickOnSecuriy()
	{
		security.click();
	}
	
	public boolean booleanCheckSecOptionsAvail(String option)
	{
		return Dd.isOptionPresent(security, option);
	}
	
	public void enterAllInfoOnPropDet()
	{
		marketValue.sendKeys(dg.getMarketValue());
		carpetValue.sendKeys(dg.getCarpetValue());
		pincode.sendKeys(dg.getPincode());
		clickOnAgeOfBuilding("5 to 10 Years");
		 clickOnPropertyEffected("no");
		 clickOnSecurity("yes");
		
		
		
	}
	
	public void clickOnAgeOfBuilding(String value)
	{
		Dd.selectByValue(ageOfBuild, value);
	}
	
	public void clickOnPropertyEffected(String value)
	{
		Dd.selectByValue(propertyEff, value);
	}
	
	public void clickOnSalariedPerson(String value)
	{
		Dd.selectByValue(salariedPerson, value);
	}
	public void clickOnSecurity(String value)	
	{
		Dd.selectByValue(security, value);
	}
	public void clickOnProceed() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		proceed.click();
	}
	
	public boolean verifyPage(String val)
	{
		return driver.getPageSource().contains(val);
	}
	
	public void enterMarketValue(String keys)
	{
		marketValue.clear();
		marketValue.sendKeys(keys);
		
	}
	public boolean checkErrorMessage(String err)
	{
		return driver.getPageSource().contains(err);
	}

	

}
