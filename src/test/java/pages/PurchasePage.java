package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zip = By.id("zipCode");
    By cardType = By.id("cardType");
    By cardNumber = By.id("creditCardNumber");
    By month = By.id("creditCardMonth");
    By year = By.id("creditCardYear");
    By nameOnCard = By.id("nameOnCard");
    By purchaseBtn = By.cssSelector("input[type='submit']");

    public void enterDetails()
    {
        driver.findElement(name).sendKeys("Roshni");
        driver.findElement(address).sendKeys("Korba");
        driver.findElement(city).sendKeys("Korba");
        driver.findElement(state).sendKeys("Chhattisgar");
        driver.findElement(zip).sendKeys("440011");

        driver.findElement(cardNumber).sendKeys("1234567812345678");
        driver.findElement(month).clear();
        driver.findElement(month).sendKeys("12");

        driver.findElement(year).clear();
        driver.findElement(year).sendKeys("2028");

        driver.findElement(nameOnCard).sendKeys("Roshni Gidwani");
    }

    public void purchaseFlight()
    {
        driver.findElement(purchaseBtn).click();
    }
}