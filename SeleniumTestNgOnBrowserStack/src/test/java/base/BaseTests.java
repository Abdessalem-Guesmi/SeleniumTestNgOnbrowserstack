package base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.GooglePage;

public class BaseTests {

	public WebDriver driver;

	protected static GooglePage googlePage;
	public static final String USERNAME = "abdessalemguesmi1";
	public static final String AUTOMATE_KEY = "aWqz2o3HymSuBheDSWs9";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@BeforeMethod
	public void setUp(Method method) throws MalformedURLException {
		System.out.println(URL);
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "latest");
		// caps.setCapability("browserstack.idleTimeout", 180);
		caps.setCapability("name", "Abdessalem");
		caps.setCapability("name", "Google_" + method.getName());
		driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://www.google.com/");
		googlePage = new GooglePage(driver);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
