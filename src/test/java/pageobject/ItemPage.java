package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePageModel{
    @FindBy (xpath = "//div[@id='aod-offer-added-to-cart-2']//div[@class='a-alert-content'][normalize-space()='Added']")
    private WebElement addedItemMassage;
    @FindBy(xpath = "//a[@id='nav-cart']")
    private WebElement cartImageElement;
    @FindBy(xpath = "//span[@id='a-autoid-2-offer-2']//input[@name='submit.addToCart']")
    private WebElement buttonAddToCart;
    @FindBy(xpath = "//i[@aria-label='aod-close']")
    private WebElement closeAllBuyOptions;
    @FindBy(xpath = "//a[@title='See All Buying Options']")
    private WebElement buttonAllBuyingOptions;
    public ItemPage(WebDriver driver) {
        super(driver);
    }
    public ItemPage addItemToCart() {
        waitForElement(buttonAddToCart).click();
        return new ItemPage(getDriver());
    }

    public ItemPage closeOptionsList() {
        Actions actions = new Actions(getDriver());
        actions.pause(3000).click(waitForElement(closeAllBuyOptions)).pause(3000).build().perform();
        return new ItemPage(getDriver());
    }
    public ItemPage clickButtonAllBuyingOptions() {
        waitForElement(buttonAllBuyingOptions).click();
        return new ItemPage(getDriver());
    }
    public CartPage clickOnCartImage() {
        waitForElement(cartImageElement).click();
        return new CartPage(getDriver());
    }
    public String getTextFromAddElement() {
        return waitForElement(addedItemMassage).getText();
    }
}
