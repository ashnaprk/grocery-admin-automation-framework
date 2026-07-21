package testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtilities;


public class LoginTest extends Base {
	@Test(description = "Verify user can sign in successfully with valid username and valid password and is redirected to the dashboard page.")
	public void verifyLoginWithValidUsernameAndValidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtilities.getStringData(1, 0, "LoginTestData");
		String password = ExcelUtilities.getStringData(1, 1, "LoginTestData");
		login.enterCredentials(username, password);
		login.clickSignIn();
		String actualTitle=login.isUserSignedIn();
		assertEquals(actualTitle, Constants.DASHBOARD_TITLE);

	}
}
