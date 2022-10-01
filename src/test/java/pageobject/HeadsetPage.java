package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeadsetPage extends BasePageModel{
    @FindBy(xpath = "//img[@alt='HyperX Cloud II - Gaming Headset, 7.1 Surround Sound, Memory Foam Ear Pads, Durable Aluminum Frame, Detachable Microphone,...']")
    private WebElement headphoneHyperXCloudII;
    public HeadsetPage(WebDriver driver) {
        super(driver);
    }
    public ItemPage clickOnHeadphoneHyperXCloudII() {
        waitForElement(headphoneHyperXCloudII).click();
        return new ItemPage(getDriver());
    }
}
