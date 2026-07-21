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

	@FindBy(xpath="(//a[@class='small-box-footer'])[11]")
	WebElement moreInfoButton;
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

	public void addNewLocation(String locationField, String deliveryChargeField) {
		page.scrollToElement(driver, moreInfoButton);
		page.javaScriptClick(driver, moreInfoButton);
		newButton.click();
		PageUtility.selectByIndexDropDown(countryId, 0);
		PageUtility.selectByVisibleTextDropdowm(stateId, "Cambridge");
		location.sendKeys(locationField);
		deliveryCharge.sendKeys(deliveryChargeField);
		page.scrollToElement(driver, saveButton);
		page.javaScriptClick(driver, saveButton);

	}

	public boolean isNewLocationAdded() {
		return newLocationAddedSuccessAlert.isDisplayed();
	}

}
