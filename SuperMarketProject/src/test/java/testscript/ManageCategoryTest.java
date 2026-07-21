package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	@Test
	public void verifyUserCanAddANewCateogory() throws IOException {
		LoginPage login = new LoginPage(driver);
		ManageCategoryPage category = new ManageCategoryPage(driver);
		String username = ExcelUtility.getStringData(1, 0, "LoginTestData");
		String password = ExcelUtility.getStringData(1, 1, "LoginTestData");
		login.enterCredentials(username, password);
		login.clickSignIn();
		category.clickOnMoreInfo();
		category.clickOnNew();
		String categoryName = ExcelUtility.getStringData(1, 0, "ManageCategoryData");
		category.enterCategoryName(categoryName);
		category.selectGroupName();
		category.chooseFileForUpload();
		category.selectShowTopMenuNoRadioButton();
		category.selectShowLeftMenuNoRadioButton();
		category.clickOnSaveButton();
		boolean sucessAlertDisplayed = category.isCategoryAddedSuccessMsgDisplayed();
		assertTrue(sucessAlertDisplayed, Constants.CATEGORY_NOT_ADDED);

	}
}
