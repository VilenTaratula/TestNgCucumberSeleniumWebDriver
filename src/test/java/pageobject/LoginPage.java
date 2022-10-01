package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageModel{
    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;
    @FindBy(id = "ap_password")
    private WebElement inputPhone;
    @FindBy(id = "continue")
    private WebElement buttonContinue;
    @FindBy(id = "signInSubmit")
    private WebElement buttonSubmit;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputEmailAndClick() {
        waitForElement(inputEmail).sendKeys("abc@gmail.com");
        waitForElement(buttonContinue).click();
        return this;
    }

    public LoginPage clickButtonContinue() {
        waitForElement(buttonContinue).click();
        return this;
    }
    public LoginPage inputPhoneAndClick() {
        waitForElement(inputPhone).sendKeys("1234567890");
        waitForElement(buttonSubmit).click();
        return this;
    }
}
