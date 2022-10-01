package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.CartPage;
import pageobject.ItemPage;
import pageobject.MainPage;

import static org.testng.Assert.assertEquals;
import static pageobject.CucumberDriver.getDriver;

public class CartCheck {
    ItemPage itemPage;
    CartPage cartPage;

    @Given("I select item option")
    public void i_select_item_option() {
        itemPage = new MainPage(getDriver())
                .clickOnHeadset()
                .clickOnHeadphoneHyperXCloudII()
                .clickButtonAllBuyingOptions();
    }

    @Given("I add item to cart")
    public void i_add_item_to_cart() {
        cartPage = new MainPage(getDriver())
                .clickOnHeadset()
                .clickOnHeadphoneHyperXCloudII()
                .clickButtonAllBuyingOptions()
                .addItemToCart()
                .closeOptionsList()
                .clickOnCartImage();
    }

    @When("I click on add item to cart")
    public void i_click_on_add_item_to_cart() {
        itemPage.addItemToCart();

    }

    @Then("I have added one item in cart")
    public void i_have_added_one_item_in_cart() {
        assertEquals(itemPage.getTextFromAddElement(), "Added");
    }

    @Then("I have one item in cart")
    public void i_have_one_item_in_cart() {
        assertEquals(cartPage.getQuantityItems(), "Subtotal (1 item):");
    }

    @When("I click delete item from cart")
    public void i_click_delete_item_from_cart() {
        cartPage = cartPage.deleteItem();
    }

    @Then("I have empty cart")
    public void i_have_empty_cart() {
        assertEquals(cartPage.getQuantityItems(), "Subtotal (0 items):");
    }
}
