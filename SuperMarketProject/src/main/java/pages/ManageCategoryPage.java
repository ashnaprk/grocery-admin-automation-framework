package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtiltity;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {

	WebDriver driver;
	FileUploadUtiltity fileUpload = new FileUploadUtiltity();
	WaitUtility wait = new WaitUtility();
	PageUtility page = new PageUtility();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// @FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
	// WebElement moreInfoButtonCateogory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement enterCategory;
	@FindBy(xpath = "//li[@id='1-selectable']")
	WebElement goodnessGroup;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileUpload;
	@FindBy(xpath = "(//input[@value='no'])[1]")
	WebElement showTopMenuNoRadioButton;
	@FindBy(xpath = "(//input[@value='no'])[2]")
	WebElement showLeftMenuNoRadioButton;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement categoryAddedSuccessMsg;

	/*
	 * public HomePage clickOnMoreInfo() { // wait.elementToBeSelected(driver,
	 * moreInfoButtonCateogory); page.javaScriptClick(driver,
	 * moreInfoButtonCateogory); return new HomePage(driver); //
	 * moreInfoButtonCateogory.click(); }
	 */

	public ManageCategoryPage clickOnNew() {
		newButton.click();
		return this;
	}

	public ManageCategoryPage enterCategoryName(String categoryfield) {
		enterCategory.sendKeys(categoryfield);
		return this;

	}

	public ManageCategoryPage selectGroupName() {
		goodnessGroup.click();
		return this;
	}

	public ManageCategoryPage chooseFileForUpload() {
		page.scrollToElement(driver, chooseFileUpload);

		fileUpload.sendKeysForFileUpload(chooseFileUpload, Constants.TESTDATAIMAGE);
		return this;
	}

	public ManageCategoryPage selectShowTopMenuNoRadioButton() {
		page.javaScriptClick(driver, showTopMenuNoRadioButton);
		return this;
	}

	public ManageCategoryPage selectShowLeftMenuNoRadioButton() {
		page.javaScriptClick(driver, showLeftMenuNoRadioButton);
		return this;
	}

	public ManageCategoryPage clickOnSaveButton() {
		page.scrollToElement(driver, saveButton);
		page.javaScriptClick(driver, saveButton);
		return this;
	}

	public boolean isCategoryAddedSuccessMsgDisplayed() {
		return categoryAddedSuccessMsg.isDisplayed();
	}

}
