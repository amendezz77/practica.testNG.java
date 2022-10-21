package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
	
	private By sigIn = By.className("login");
	private By inputUserlocator = By.id("email"); 
	private By inputPassword = By.id("passwd");
	private By btnSigIn = By.cssSelector("i.icon-lock.left");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void loginUser(String user, String pass) {
		Click(sigIn);
		inputText(user, inputUserlocator);
		inputText(pass, inputPassword);
		Click(btnSigIn);
	}
}
