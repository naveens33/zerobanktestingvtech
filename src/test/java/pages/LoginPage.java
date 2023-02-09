package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user_login")
    WebElement userNameTextField;

    @FindBy(id = "user_password")
    WebElement passwordTextField;

    @FindBy(name = "submit")
    WebElement signInButton;

    public void doLogin(String username, String password){
        userNameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        signInButton.click();
    }

}
