package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {

	WebDriver driver;
	PageUtility page = new PageUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='nav-link' and @data-toggle='dropdown']")
	WebElement adminButton;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutButton;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signIn;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
	WebElement moreInfoButtonCateogory;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[11]")
	WebElement moreInfoButtonOfLocation;

	public HomePage clickAdminButton() {
		adminButton.click();
		return this;

	}

	public LoginPage clickLogoutButton() {
		logoutButton.click();
		return new LoginPage(driver);
	}

	public String isLoggedOut() {
		return driver.getTitle();
	}

	public ManageCategoryPage clickOnMoreInfo() {
		// wait.elementToBeSelected(driver, moreInfoButtonCateogory);
		page.javaScriptClick(driver, moreInfoButtonCateogory);

		return new ManageCategoryPage(driver);
		// moreInfoButtonCateogory.click();
	}

	public ManageLocationPage clickMoreInfoButtonLocation() {
		page.scrollToElement(driver, moreInfoButtonOfLocation);
		page.javaScriptClick(driver, moreInfoButtonOfLocation);
		return new ManageLocationPage(driver);
	}

}
