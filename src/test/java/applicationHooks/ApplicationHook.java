package applicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHook {

	private DriverFactory df;
	private WebDriver driver;
	private Properties prop;
	private ConfigReader configReader;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.readConfig();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browser = prop.getProperty("browser");
		driver = new DriverFactory().init_driver(browser);
		

	}

	@After(order = 1)
	public void tearDown(Scenario sce) {
		if (sce.isFailed()) {
			String screenshotName = sce.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sce.attach(sourcePath, "image/png", screenshotName);
		}
		
	}
	
	@After(order =0)
	public void quitBrowser()
	{
		driver.quit();
	}

}
