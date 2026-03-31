package tdd;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	
	@Test
	public void verify_Login_With_Valid_Data() {
		loginPage.login("Hello", "World");
	}

}
