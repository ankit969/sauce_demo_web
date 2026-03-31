package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BasePage{
	
	private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
	
	public void login(String username, String password) {
        basicActionsUtils.enter(usernameField, username);
        basicActionsUtils.enter(passwordField, password);
        basicActionsUtils.click(loginButton);
    }

}
