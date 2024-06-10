package TestCompoents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pageobjects.LandingPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

	public static WebDriver driver;
	public static LandingPage landingPage;

	public void InitializeBrowser() throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\resources\\GlobalData.properties");
		properties.load(fis);

		String browserName = properties.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}
	
	@DataProvider
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath));	
	//String to HashMap- Jackson Datbind	
	 ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new com.fasterxml.jackson.core.type.TypeReference<List<HashMap<String, String>>>() {
     });
	  return data;
	
	//{map, map}
	}
	

	@BeforeMethod(alwaysRun = true)
	public void LaunchApplication() throws IOException {
		InitializeBrowser();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
