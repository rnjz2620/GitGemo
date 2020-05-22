package qaclickacademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage1;
import resource.base;
import resources.Base;

public class validateNavigationBar extends Base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void basePageNavigation() throws IOException {

		LandingPage1 l = new LandingPage1(driver);

		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation bars is displayed");
		// Assert.assertFalse(condition);

	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver=null;
	}

}
