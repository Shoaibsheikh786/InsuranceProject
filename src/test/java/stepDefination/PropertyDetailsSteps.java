package stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.PropertyDetailsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PropertyDetailsSteps {
	private WebDriver driver;
	private PropertyDetailsPage propDetPage;
	private HomePage homePage;
	
	@Given("user is on the property page")
	public void user_is_on_the_property_page() {
		driver=DriverFactory.getDriver();
		driver.get(new ConfigReader().readConfig().getProperty("url"));;
		homePage=new HomePage(driver);
	   propDetPage=	homePage.getPropertyDetails();
	}
	
	@When("user clicks on the age of building")
	public void user_click_on_the_age_of_buiding()
	{
		propDetPage.clickOnAgeOfBuild();
	}
	
	@Then("user can see the {int} values")
	public void user_can_see_the_values(Integer n) {
		int all=propDetPage.countOptions();
		Assert.assertEquals(all,n);
	}
	
	@Then("user can see these options {string}")
	public void user_can_see_these_options(String value) {
	  Assert.assertTrue(propDetPage.checkOptionAvailable(value));
	  
	}
	
	@When("user clicks on  security")
	public void click_on_security()
	{
		propDetPage.clickOnSecuriy();
	}
	@Then("user should be able to see {string}")
	public void checkOptionsPresent(String option)
	{
		propDetPage.booleanCheckSecOptionsAvail(option);
	}
	
	@When("user enters all the necessary details")
	public void userEntersAllTheNecessaryDetails()
	{
		propDetPage.enterAllInfoOnPropDet();
		propDetPage.clickOnSalariedPerson("yes");
	}
	
	@And("user checks salaried person as {string}")
	public void clickonSalriedPersonAs(String val)
	{
		propDetPage.clickOnSalariedPerson(val);
	}
	
	@Then("user can proceed")
	public void clickOnProceed()
	{
		propDetPage.clickOnProceed();
	}
  
	@Then("user is navigated to {string} page")
	public void checkPageDetails(String  page)
	{
		Assert.assertTrue(propDetPage.verifyPage(page));
	}
	
	
	@Then("user should get pop up {string}")
	public void checkPopUp(String popup)
	{
		Assert.assertTrue(propDetPage.verifyPage(popup));
	}
	
	@When("user gives wrong input Current Market {string}")
	public void enterWronDetailsCurrentMarketValues(String val)
	{
		propDetPage.enterMarketValue(val);
	}
	@Then("user should see error message {string}")
	public void checkErroMessage(String err)
	{
		propDetPage.checkErrorMessage(err);
	}
	
	
	
}
