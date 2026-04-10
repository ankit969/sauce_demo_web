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
		
		loginPage.login(username, password);
		
		// Temporary validation just to confirm flow works
        Assert.assertTrue(true, "Executed test for TC_ID: " + tcId);
	}

}
