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

public class validateTitle extends Base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
	}

	@Test
	public void baseValidateTitle() throws IOException {

		LandingPage1 l = new LandingPage1(driver);

		// Assert.assertEquals(l.getTitle().getText(),"Featured Courses");
		// Actual Text FEATURED COURSES, Test should be failed
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated Text message");
		// Actual Text FEATURED COURSES, Test should be passed

	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver=null;
	}

}
