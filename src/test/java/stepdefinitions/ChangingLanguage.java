package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.MainPage;

import static org.testng.AssertJUnit.assertEquals;
import static pageobject.CucumberDriver.getDriver;

public class ChangingLanguage {

    public static MainPage mainPage;
    String actualLanguages;

    @Given("I am at main page")
    public void i_am_at_main_page() {
        mainPage = new MainPage(getDriver());
    }

    @When("I change to German")
    public void iChangeToGerman() {
        mainPage = mainPage.changingLanguages();
    }

    @Then("I expect German on page")
    public void iExpectGermanOnPage() {
        assertEquals("Hallo, anmelden"
                , mainPage.checkLanguage());

    }
    @When("I change languages")
    public void iChangeLanguages() {
        actualLanguages =  MainPage.changedLanguages();
    }

    @Then("I expect ganged languages on page")
    public void iExpectGagedLanguagesOnPage() {
        assertEquals("\"Hello, sign in\", \"Hola, Identifícate\", \"مرحباً. تسجيل الدخول\", \"שלום, היכנס\"" +
                        ", \"안녕하세요, 로그인\", \"안녕하세요, 로그인\", \"Olá, faça seu login\", \"您好, 登录\"" +
                        ", \"您好，登入\", \"Hello, sign in\""
                , actualLanguages);
    }

}
