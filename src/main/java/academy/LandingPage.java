package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	By signin = By.cssSelector("a[herf*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By popup = By.xpath("//button[text()='NO THANKS']");

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	public WebElement getSignin() {
		return driver.findElement(signin);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getnavigationBar() {
		return driver.findElement(navBar);
	}

	public WebElement getPopup() {
		return driver.findElement(popup);
	}

}
