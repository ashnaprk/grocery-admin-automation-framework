package testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {
	@Test(description = "Verify user can log out successfully and is redirected to the login page.")
	public void verifyLogout() throws IOException {
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		String username = ExcelUtility.getStringData(1, 0, "LoginTestData");
		String password = ExcelUtility.getStringData(1, 1, "LoginTestData");
		login.enterCredentials(username, password);
		login.clickSignIn();
		home.clickLogout();
		String actualTitle=home.isLoggedOut();
		assertEquals(actualTitle, Constants.LOGINPAGE_TITLE);

	}
}
