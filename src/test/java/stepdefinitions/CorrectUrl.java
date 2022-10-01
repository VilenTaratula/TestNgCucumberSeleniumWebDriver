package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HeadsetPage;
import pageobject.ItemPage;
import pageobject.MainPage;

import static org.testng.AssertJUnit.assertEquals;
import static pageobject.CucumberDriver.getDriver;


public class CorrectUrl {

    String loginPageUrl = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
    MainPage mainPage;
    HeadsetPage headsetPage;
    ItemPage itemPage;

    @Given("I am at home page")
    public void i_am_at_home_page() {
        mainPage = new MainPage(getDriver());
    }

    @Given("I am at  headset page")
    public void i_am_headset_page() {
        headsetPage = new MainPage(getDriver())
                .clickOnHeadset();
    }

    @When("I click on logo")
    public void i_click_on_log() {
        mainPage.clickLogoImage();
    }

    @When("I click on login")
    public void i_click_on_login() {
        mainPage.clickOnLoginImage();
    }

    @When("I click on cart")
    public void i_click_on_cart() {
        mainPage.clickOnCartImage();
    }

    @When("I click on headset")
    public void i_click_on_headset() {
        headsetPage = mainPage.clickOnHeadset();
    }

    @When("I click on headset item")
    public void i_click_on_headset_item() {
        itemPage = headsetPage.clickOnHeadphoneHyperXCloudII();
    }

    @Then("i should be on home page")
    public void i_should_be_on_home_page() {
        assertEquals("https://www.amazon.com/ref=nav_logo", mainPage.getDriver().getCurrentUrl());
    }

    @Then("i should be on login page")
    public void i_should_be_on_login_page() {
        assertEquals(loginPageUrl, mainPage.getDriver().getCurrentUrl());
    }

    @Then("I should be on cart page")
    public void i_should_be_on_cart_page() {
        assertEquals("Amazon.com Shopping Cart", mainPage.getDriver().getTitle());
    }

    @Then("I should be on headset page")
    public void i_should_be_on_headset_page() {
        assertEquals("Amazon.com : gaming headsets", headsetPage.getDriver().getTitle());
    }

    @Then("I should be on headset item page")
    public void i_should_be_on_headset_item_page() {
        assertEquals("HyperX Cloud II - Gaming Headset, 7.1 Surround Sound, Memory Foam Ear Pads",
                itemPage.getDriver().getTitle().substring(12, 86));
    }
}
