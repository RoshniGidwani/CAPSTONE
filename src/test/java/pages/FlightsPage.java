package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class FlightsPage {

    WebDriver driver;
    WaitUtils wait;

    public FlightsPage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    By flightHeader = By.xpath("//h3");

    By chooseFlight = By.xpath("(//input[@value='Choose This Flight'])[1]");

    public boolean isFlightsDisplayed()
    {
        return wait.waitForElementVisible(flightHeader).isDisplayed();
    }

    public void chooseFirstFlight()
    {
        wait.waitForElementClickable(chooseFlight).click();
    }
}