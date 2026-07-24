package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageLocationPage {

	WebDriver driver;
	WaitUtility wait = new WaitUtility();
	PageUtility page = new PageUtility();

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']")
	WebElement countryId;
	@FindBy(xpath = "//select[@id='st_id']")
	WebElement stateId;
	@FindBy(xpath = "//input[@id='location']")
	WebElement location;
	@FindBy(xpath = "//input[@id='delivery']")
	WebElement deliveryCharge;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newLocationAddedSuccessAlert;

	public ManageLocationPage clickNewButton() {

		newButton.click();
		return this;
	}

	public ManageLocationPage selectCountryFromDropDown() {
		wait.elementToBeClicked(driver, countryId);
		PageUtility.selectByIndexDropDown(countryId, 1);
		return this;
	}

	public ManageLocationPage selectStateFromDropDown() {
		wait.elementToBeClicked(driver, countryId);
		PageUtility.selectByIndexDropDown(stateId, 5);
		return this;
	}

	public ManageLocationPage enterLocation(String locationField) {

		location.sendKeys(locationField);
		return this;
	}

	public ManageLocationPage enterDeliveryCharge(String deliveryChargeField) {
		deliveryCharge.sendKeys(deliveryChargeField);
		return this;
	}

	public ManageLocationPage clickSaveButton() {

		page.scrollToElement(driver, saveButton);
		wait.elementToBeClicked(driver, saveButton);
		page.javaScriptClick(driver, saveButton);
		return this;

	}

	public boolean isNewLocationAdded() {
		return newLocationAddedSuccessAlert.isDisplayed();
	}

}
