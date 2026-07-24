package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base {
	HomePage home;
	ManageLocationPage location;

	@Test(description = "Verify new location is added in the Manage Location.", groups = "smoke")
	public void verifyUserCanAddNewLocation() throws IOException {
		LoginPage login = new LoginPage(driver);
		ManageLocationPage location = new ManageLocationPage(driver);
		String username = ExcelUtility.getStringData(1, 0, "LoginTestData");
		String password = ExcelUtility.getStringData(1, 1, "LoginTestData");
		login.enterCredentials(username, password);
		home = login.clickSignIn();
		location = home.clickMoreInfoButtonLocation();
		location.clickNewButton().selectCountryFromDropDown().selectStateFromDropDown()
				.enterLocation(ExcelUtility.getStringData(1, 0, "ManageLocationTestData"))
				.enterDeliveryCharge(ExcelUtility.getIntData(1, 1, "ManageLocationTestData")).clickSaveButton();

		boolean sucessAlertDisplayed = location.isNewLocationAdded();
		assertTrue(sucessAlertDisplayed, Constants.LOCATION_NOT_ADDED);

	}
}
