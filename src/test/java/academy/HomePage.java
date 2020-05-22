package academy;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resource.base;

public class HomePage extends base {

public static Logger log = LogManager.getLogger(base.class.getName());

@BeforeTest
public void initialize() throws IOException {
driver = startDriver();}

@Test(dataProvider = "getData")
public void basePageNavigation(String username, String password, String text) throws IOException {

		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.getSignin().click();
		LoginPage lg = new LoginPage(driver);
		lg.getEmail().sendKeys(username);
		lg.getPassword().sendKeys(password);
		lg.getLogin().click();
		log.info("text"); }
@DataProvider
public Object[][] getData() {
		
	Object[][] data = new Object[2][3];
		// 1st Set
		data[0][0] = "reazjz4@gmail.com";
		data[0][1] = "Dulal@2620";
		data[0][2] = "Valid User";
		// 2nd Set
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "123456";
		data[1][2] = "Invalid User";
		return data;
}
	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}
