package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ConfirmationPage;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchasePage;
import utils.ExcelUtils;

public class FlightBookingTest extends BaseTest {

    @DataProvider(name = "flightData")
    public Object[][] getData() throws IOException
    {
        return ExcelUtils.getExcelData();
    }

    @Test(dataProvider = "flightData")
    public void bookFlightTest(String departure, String destination,
                               String fullName, String fullAddress,
                               String cityName, String stateName,
                               String zipCode, String creditCardNumber,
                               String cardMonth, String cardYear,
                               String cardHolderName)
    {
        HomePage home = new HomePage(driver);
        home.selectDeparture(departure);
        home.selectDestination(destination);
        home.clickFindFlights();

        FlightsPage flights = new FlightsPage(driver);

        boolean flightsVisible = flights.isFlightsDisplayed();
        System.out.println("Flights visible: " + flightsVisible);

        Assert.assertTrue(flightsVisible, "Flights list is not displayed");

        flights.chooseFirstFlight();

        PurchasePage purchase = new PurchasePage(driver);
        purchase.enterDetails(fullName, fullAddress, cityName, stateName,
                zipCode, creditCardNumber, cardMonth, cardYear, cardHolderName);
        purchase.purchaseFlight();

        System.out.println("Current URL after purchase: " + driver.getCurrentUrl());

        ConfirmationPage confirm = new ConfirmationPage(driver);
        String message = confirm.getConfirmationMessage();

        System.out.println("Actual confirmation message: " + message);

        Assert.assertTrue(message.contains("Thank you for your purchase"),
                "Booking confirmation message not displayed");

        System.out.println("Flight booking completed successfully for: " + fullName);
    }
}