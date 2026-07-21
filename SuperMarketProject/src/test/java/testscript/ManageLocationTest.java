package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtilities;

public class ManageLocationTest extends Base {
	@Test(description = "Verify new location is added in the Manage Location.")
	public void verifyUserCanAddNewLocation() throws IOException {
		LoginPage login = new LoginPage(driver);
		ManageLocationPage manage = new ManageLocationPage(driver);
		String username = ExcelUtilities.getStringData(1, 0, "LoginTestData");
		String password = ExcelUtilities.getStringData(1, 1, "LoginTestData");
		login.enterCredentials(username, password);
		login.clickSignIn();
		String location = ExcelUtilities.getStringData(1, 0, "ManageLocationTestData");
		String deliveryCharge = ExcelUtilities.getIntData(1, 1, "ManageLocationTestData");
		manage.addNewLocation(location,deliveryCharge);
		boolean sucessAlertDisplayed = manage.isNewLocationAdded();
		assertTrue(sucessAlertDisplayed,Constants.LOCATION_NOT_ADDED_MSG);
		
		

	}
}
