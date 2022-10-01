package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinitions.ChangingLanguage;

import java.time.Duration;

public class MainPage extends BasePageModel {
    @FindBy(id = "nav-logo-sprites")
    private WebElement logoImageElement;
    @FindBy(id = "nav-link-accountList")
    private WebElement loginImageElement;
    @FindBy(id = "nav-cart")
    private WebElement cartImageElement;
    @FindBy(xpath = "//a[contains(@class,'a-link-normal image-redirect aok-block image-window')]")
    private WebElement headsetElement;
    @FindBy(xpath = "//a[contains(@id,'icp-nav-flyout')]")
    private WebElement languageBarElement;
    @FindBy(xpath = "//div[@id='nav-flyout-icp']//span[@dir='ltr'][normalize-space()='Deutsch']")
    private WebElement languageGermanElement;
    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    private WebElement verifyLanguageElement;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickLogoImage() {
        waitForElement(logoImageElement).click();
        return this;
    }

    public LoginPage clickOnLoginImage() {
        waitForElement(loginImageElement).click();
        return new LoginPage(getDriver());
    }

    public CartPage clickOnCartImage() {
        waitForElement(cartImageElement).click();
        return new CartPage(getDriver());
    }

    public HeadsetPage clickOnHeadset() {
        waitForElement(headsetElement).click();
        return new HeadsetPage(getDriver());
    }

    public MainPage changingLanguages() {
        Actions actions = new Actions(getDriver());
        actions.pause(2000).moveToElement(waitForElement(languageBarElement)).pause(1000).build().perform();
        actions.pause(1000).moveToElement(languageGermanElement).click().pause(1000).build().perform();
        return new MainPage(getDriver());
    }

    public MainPage changingLanguages(String languageChangeToXpath) {
        Actions actions = new Actions(getDriver());
        actions.pause(2000).moveToElement(waitForElement(languageBarElement)).pause(1000).build().perform();
        actions.pause(1000).moveToElement(findElement(languageChangeToXpath)).click().pause(2000).build().perform();
        return new MainPage(getDriver());
    }

    public WebElement findElement(String xpath) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(xpath)));
    }

    public String checkLanguage() {
        return waitForElement(verifyLanguageElement).getText();
    }

    public static String changedLanguages() {
        StringBuilder res = new StringBuilder();
        res.append("\"").append(ChangingLanguage.mainPage.checkLanguage()).append("\", ");
        String[] elementXpathArr = {"//div[@id='nav-flyout-icp']//span[@dir='ltr'][normalize-space()='español']"
                , "//div[@id='nav-flyout-icp']//span[contains(@dir,'ltr')][normalize-space()='AR']"
                , "//div[@id='nav-flyout-icp']//span[contains(@dir,'ltr')][normalize-space()='HE']"
                , "//div[@id='nav-flyout-icp']//span[contains(@dir,'ltr')][contains(text(),'한국어')]"
                , "//div[@id='nav-flyout-icp']//span[contains(@dir,'ltr')][normalize-space()='KO']"
                , "//div[@id='nav-flyout-icp']//span[contains(@dir,'ltr')][normalize-space()='português']"
                , "//div[@id='nav-flyout-icp']//span[@dir='ltr'][contains(text(),'中文 (简体)')]"
                , "//div[@id='nav-flyout-icp']//span[@dir='ltr'][contains(text(),'中文 (繁體)')]"
                , "//div[@id='nav-flyout-icp']//span[contains(@dir,'ltr')][normalize-space()='English']"};
        for (int i = 0; i < elementXpathArr.length; i++) {
            ChangingLanguage.mainPage = ChangingLanguage.mainPage.changingLanguages(elementXpathArr[i]);
            res.append("\"").append(ChangingLanguage.mainPage.checkLanguage()).append("\"");
            if (i < elementXpathArr.length - 1) {
                res.append(", ");
            }
        }
        return res.toString();
    }

}
