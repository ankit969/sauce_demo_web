package bdd.stepdefinitions;

import org.testng.Assert;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
	
	LoginPage loginPage = new LoginPage(DriverManager.getDriver());
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		loginPage.open();
	}
	
	@When("user enters username {string} and password {string} and click on login button")
    public void user_enters_credentials(String username, String password) {
        loginPage.login(username, password);
    }
	
	@Then("login result should be {string}")
    public void verify_login_result(String expectedResult) {
        if (expectedResult.equalsIgnoreCase("SUCCESS")) {
            Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should be successful");
        } else {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        }
    }
	
	@And("error message should be {string}")
    public void verify_error_message(String expectedMessage) {
        if (expectedMessage != null && !expectedMessage.isEmpty()) {
            String actualMessage = loginPage.getErrorMessage();
            Assert.assertEquals(actualMessage, expectedMessage);
        }
    }

}
