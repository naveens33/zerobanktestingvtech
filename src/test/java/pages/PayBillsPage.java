package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayBillsPage {
    WebDriverWait wait;

    public PayBillsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(linkText = "Add New Payee")
    WebElement addNewPayeeLink;

    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    WebElement nameTextField;

    @FindBy(css = "textarea#np_new_payee_address")
    WebElement addressTextArea;

    @FindBy(id="np_new_payee_account")
    WebElement accountTextField;

    @FindBy(id="np_new_payee_details")
    WebElement detailsTextField;

    @FindBy(id="add_new_payee")
    WebElement addButton;

    public  void clickAddNewPayeeLink(){
        addNewPayeeLink.click();
    }

    public void doAddPayee(String name, String address, String account, String details){
        wait.until(ExpectedConditions.visibilityOf(nameTextField)).sendKeys(name);
        addressTextArea.sendKeys(address);
        accountTextField.sendKeys(account);
        detailsTextField.sendKeys(details);
        addButton.click();
    }
}
