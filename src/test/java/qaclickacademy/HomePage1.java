package qaclickacademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import academy.LandingPage;
import pageObjects.LandingPage1;
import pageObjects.LoginPage1;
import resource.base;
import resources.Base;

public class HomePage1 extends Base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test(dataProvider = "getData")
	public void home1PageNavigation(String UserName, String Password, String Text) throws IOException {
		
		driver.get(prop.getProperty("url"));
	
		LandingPage1 lp = new LandingPage1(driver);
		if(lp.getPopupSize().size()>0) {
			lp.getPopup().click();
		}
		lp.getSignin().click();
		LoginPage1 l = new LoginPage1(driver);
		l.getEmail().sendKeys(UserName);
		//System.out.println(Text);
		log.info("text");
		l.getPassword().sendKeys(Password);
		l.getlogin().click();

		/*
		 * la.getEmail().sendKeys(UserName); Correction above,
		 * la.getPassword().sendKeys(Password); System.out.println(Text);
		 * la.getlogin().click();
		 */

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "nonrestrictedusr@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";

		data[1][0] = "restricted@gmail.com";
		data[1][1] = "456789";
		data[1][2] = "Non Restricted User";
		
		return data;
	}

	@AfterTest
	public void teardown() {

		driver.close();
	}
}

