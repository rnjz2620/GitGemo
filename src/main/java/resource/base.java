package resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	
	public WebDriver startDriver() throws IOException {

		 prop = new Properties();// invoking browser file location path to file stream
		 fis = new FileInputStream(
		"C:\\Users\\reazj\\E2EFramework\\src\\main\\java\\qaclickacademy\\initialize.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");// prop invoke and stored browser

		if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Works\\chromedriver.exe");
		driver = new ChromeDriver();}
		
		if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "D:\\Works\\geckodriver.exe");
			driver = new FirefoxDriver();
		 
		} else if (browserName.equals("ie")) {

			System.setProperty("webdriver.ie.driver", "D:\\Works\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();

		} else if (browserName.equals("")) {

			System.setProperty("webdriver.msedge.driver", "D:\\Works\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();*/
		return driver;
		
	}
	
}
