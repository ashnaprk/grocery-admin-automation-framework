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
	WaitUtility wait =new WaitUtility();
	PageUtility page=new PageUtility();

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
	WebElement moreInfoButtonCateogory;
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
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement categoryAddedSuccessMsg;

	public void clickOnMoreInfo() {
		//wait.elementToBeSelected(driver, moreInfoButtonCateogory);
		page.javaScriptClick(driver, moreInfoButtonCateogory);
		//moreInfoButtonCateogory.click();
	}

	public void clickOnNew() {
		newButton.click();
	}

	public void enterCategoryName(String categoryfield) {
		enterCategory.sendKeys(categoryfield);

	}
	
	public void selectGroupName()
	{
		goodnessGroup.click();
	}

	public void chooseFileForUpload()  {
		page.scrollToElement(driver, chooseFileUpload);
		
		fileUpload.sendKeysForFileUpload(chooseFileUpload, Constants.TESTDATAIMAGE);

	}
	
	public void selectShowTopMenuNoRadioButton()
	{
		page.javaScriptClick(driver, showTopMenuNoRadioButton);
	}
	
	public void selectShowLeftMenuNoRadioButton()
	{
		page.javaScriptClick(driver, showLeftMenuNoRadioButton);
	}
	
	public void clickOnSaveButton()
	{
		page.scrollToElement(driver, saveButton);
		page.javaScriptClick(driver, saveButton);
	}
	
	public boolean isCategoryAddedSuccessMsgDisplayed()
	{
		return categoryAddedSuccessMsg.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	

}
