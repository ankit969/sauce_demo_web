package tdd;

import java.io.File;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelReader;

public class LoginTest extends BaseTest{
	
	private static final String FILE_PATH = System.getProperty("user.dir")+File.separator+"TestData"+File.separator+"sauce_demo_testData.xlsx";
	private static final String TEST_DATA_SHEET = "Test_Data";
	
	@DataProvider(name = "loginTestData")
	public Object[][] loginTestData(){
		return ExcelReader.getSheetDataAsDataProvider(FILE_PATH, TEST_DATA_SHEET);
	}
	
	@Test(dataProvider = "loginTestData")
	public void verify_Login_Functionality(String tcId) {

	    Map<String, String> testData = ExcelReader.getRowDataByTcId(FILE_PATH, TEST_DATA_SHEET, tcId);

	    String username = testData.get("Username");
	    String password = testData.get("Password");
	    String expectedResultType = testData.get("ExpectedResultType");
	    String expectedErrorMessage = testData.get("ExpectedErrorMessage");

	    loginPage.login(username, password);

	    if ("SUCCESS".equalsIgnoreCase(expectedResultType)) {

	        Assert.assertTrue(loginPage.isLoginSuccessful(),
	                "Expected user to land on inventory page for TC_ID: " + tcId);

	    } else if ("ERROR".equalsIgnoreCase(expectedResultType)) {

	        String actualError = loginPage.getErrorMessage();

	        Assert.assertEquals(actualError, expectedErrorMessage,
	                "Error message mismatch for TC_ID: " + tcId);
	    }
	}

}
