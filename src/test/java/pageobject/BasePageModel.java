package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


public  class BasePageModel{
    protected WebDriver driver;

    public  WebDriver getDriver() {
        return driver;
    }

    public BasePageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public WebElement waitForElement(WebElement webElement) {
        return (new WebDriverWait(getDriver(), Duration.of(15, ChronoUnit.SECONDS)))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
