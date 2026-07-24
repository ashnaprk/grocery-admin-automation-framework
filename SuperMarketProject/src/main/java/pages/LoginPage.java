package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signIn;

	public LoginPage enterCredentials(String userName, String passWord) {
		username.sendKeys(userName);
		password.sendKeys(passWord);
		return this;
		// signIn.click();
	}

	public HomePage clickSignIn() {
		signIn.click();
		return new HomePage(driver);
		// System.out.println(driver.getTitle());
	}

	public String isUserSignedIn() {
		System.out.println(driver.getTitle());
		return driver.getTitle();

	}

}
