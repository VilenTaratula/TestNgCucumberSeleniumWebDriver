package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.LoginPage;
import pageobject.MainPage;

import static org.testng.AssertJUnit.assertEquals;
import static pageobject.CucumberDriver.getDriver;

public class CheckLoginPage {
    LoginPage loginPage;

    @Given("I am at login page")
    public void i_am_at_login_page() {
        loginPage = new MainPage(getDriver()).clickOnLoginImage();
    }

    @When("I try logged with not existing account")
    public void i_try_logged_with_not_existing_account() {
    loginPage
            .inputEmailAndClick()
                .inputPhoneAndClick();
    }

    @When ("I try logged without inputting email")
    public void i_try_logged_without_inputting_email() {
        loginPage.clickButtonContinue();
    }

    @Then("I should be on login page with error massage")
    public void i_should_be_on_login_page_with_error_massage() {
        assertEquals("Amazon Sign-In",loginPage.getDriver().getTitle());
    }
}
