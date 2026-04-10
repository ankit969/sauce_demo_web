package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import config.ConfigReader;

public final class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");
    private final By inventoryPage = By.id("inventory_container");
    
    public void open() {
    	driver.get(ConfigReader.getProperty("url"));
    }
	
	public void login(String username, String password) {
        enter(usernameField, username);
        enter(passwordField, password);
        click(loginButton);
    }
	
	public String getErrorMessage() {
		return getText(errorMessage);
	}
	
	public boolean isErrorMessageDisplayed() {
		return isDisplayed(errorMessage);
	}
	
	public boolean isLoginSuccessful() {
        return isDisplayed(inventoryPage);
    }

}
