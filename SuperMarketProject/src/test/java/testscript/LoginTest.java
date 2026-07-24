package testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;

	@Test(description = "Verify user can sign in successfully with valid username and valid password and is redirected to the dashboard page.", groups = "smoke")
	public void verifyLoginWithValidUsernameAndValidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.getStringData(1, 0, "LoginTestData");
		String password = ExcelUtility.getStringData(1, 1, "LoginTestData");
		login.enterCredentials(username, password);
		home = login.clickSignIn();
		String actualTitle = login.isUserSignedIn();
		assertEquals(actualTitle, Constants.DASHBOARD_TITLE);

	}
}
