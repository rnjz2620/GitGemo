package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage1 {

	public WebDriver driver;

	By signin = By.cssSelector("a[herf*='sign_in']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navbar = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul");
	By popup = By.xpath("//button[text()='NO THANKS']");

	public LandingPage1(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement getSignin() {
		return driver.findElement(signin);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavigationBar() {
		return driver.findElement(navbar);
	}

	public List<WebElement> getPopupSize() {
		return driver.findElements(popup);
	}

	public WebElement getPopup() {
		return driver.findElement(popup);
	}

}
