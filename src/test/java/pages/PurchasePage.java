package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class PurchasePage {

    WebDriver driver;
    WaitUtils wait;

    public PurchasePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zip = By.id("zipCode");
    By cardNumber = By.id("creditCardNumber");
    By month = By.id("creditCardMonth");
    By year = By.id("creditCardYear");
    By nameOnCard = By.id("nameOnCard");
    By purchaseBtn = By.cssSelector("input[type='submit']");

    public void enterDetails(String fullName, String fullAddress, String cityName,
                             String stateName, String zipCode, String creditCardNumber,
                             String cardMonth, String cardYear, String cardHolderName)
    {
        wait.waitForElementVisible(name).sendKeys(fullName);
        driver.findElement(address).sendKeys(fullAddress);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(state).sendKeys(stateName);
        driver.findElement(zip).sendKeys(zipCode);
        driver.findElement(cardNumber).sendKeys(creditCardNumber);

        driver.findElement(month).clear();
        driver.findElement(month).sendKeys(cardMonth);

        driver.findElement(year).clear();
        driver.findElement(year).sendKeys(cardYear);

        driver.findElement(nameOnCard).sendKeys(cardHolderName);
    }

    public void purchaseFlight()
    {
        wait.waitForElementClickable(purchaseBtn).click();
    }
}