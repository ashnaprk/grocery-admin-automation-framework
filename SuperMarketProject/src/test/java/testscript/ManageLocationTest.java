package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base {
	@Test(description = "Verify new location is added in the Manage Location.",groups = "smoke")
	public void verifyUserCanAddNewLocation() throws IOException {
		LoginPage login = new LoginPage(driver);
		ManageLocationPage manage = new ManageLocationPage(driver);
		String username = ExcelUtility.getStringData(1, 0, "LoginTestData");
		String password = ExcelUtility.getStringData(1, 1, "LoginTestData");
		login.enterCredentials(username, password);
		login.clickSignIn();
		String location = ExcelUtility.getStringData(1, 0, "ManageLocationTestData");
		String deliveryCharge = ExcelUtility.getIntData(1, 1, "ManageLocationTestData");
		manage.clickNewButton();
		manage.selectCountryFromDropDown();
		manage.selectStateFromDropDown();
		manage.enterLocation(location);
		manage.enterDeliveryCharge(deliveryCharge);
		manage.clickSaveButton();
		boolean sucessAlertDisplayed = manage.isNewLocationAdded();
		assertTrue(sucessAlertDisplayed,Constants.LOCATION_NOT_ADDED);
		
		

	}
}
