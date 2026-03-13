package pages;

import org.openqa.selenium.*;

import utils.WaitUtils;

public class ConfirmationPage {

    WebDriver driver;
    WaitUtils wait;

    public ConfirmationPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    By confirmationMessage = By.xpath("//h1");

    public String getConfirmationMessage()
    {
        return wait.waitForElementVisible(confirmationMessage).getText();
    }
}