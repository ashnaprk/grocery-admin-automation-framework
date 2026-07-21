package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	WebElement adminButton;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutButton;

	public void clickLogout() {
		adminButton.click();
		logoutButton.click();
	}

	public String isLoggedOut() {
		return driver.getTitle();
	}

}
