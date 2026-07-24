package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	HomePage home;
	ManageCategoryPage category;

	@Test(description = "Verify user can add a new Category in the category page", groups = "smoke")
	public void verifyUserCanAddANewCateogory() throws IOException {
		LoginPage login = new LoginPage(driver);
		ManageCategoryPage category = new ManageCategoryPage(driver);
		String username = ExcelUtility.getStringData(1, 0, "LoginTestData");
		String password = ExcelUtility.getStringData(1, 1, "LoginTestData");
		login.enterCredentials(username, password);
		home = login.clickSignIn();
		category = home.clickOnMoreInfo();
		category.clickOnNew().enterCategoryName(ExcelUtility.getStringData(1, 0, "ManageCategoryData"))
				.selectGroupName().chooseFileForUpload().selectShowTopMenuNoRadioButton()
				.selectShowLeftMenuNoRadioButton().clickOnSaveButton();

		boolean sucessAlertDisplayed = category.isCategoryAddedSuccessMsgDisplayed();
		assertTrue(sucessAlertDisplayed, Constants.CATEGORY_NOT_ADDED);

	}
}
