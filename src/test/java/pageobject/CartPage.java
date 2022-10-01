package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePageModel{

    @FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
    private WebElement subtotalItemElement;
    @FindBy(xpath = "//span[@class='a-declarative']")
    private WebElement deleteItemButton;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getQuantityItems() {
        return waitForElement(subtotalItemElement).getText();
    }
    public CartPage deleteItem() {
        waitForElement(deleteItemButton).click();
        return new CartPage(getDriver());
    }

}
