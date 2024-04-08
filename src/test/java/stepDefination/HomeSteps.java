package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
	private HomePage propertyPage;
	private WebDriver driver;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	
	driver=DriverFactory.getDriver();
	driver.get(new ConfigReader().readConfig().getProperty("url"));
	propertyPage=new HomePage(driver);
	}
	
	@When("user clicks on insurance button")
	public void user_clicks_on_insurance_button() {
		propertyPage.clickOnPropBtn();
	}

	@Then("user is navigated to {string}")
	public void user_is_navigated_to(String heading) {
		Assert.assertTrue(propertyPage.verifyPage(heading));
		
	}


}
