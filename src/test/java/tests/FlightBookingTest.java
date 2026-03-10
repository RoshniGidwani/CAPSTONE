package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.FlightsPage;
import pages.PurchasePage;
import pages.ConfirmationPage;

public class FlightBookingTest extends BaseTest {

    @Test
    public void bookFlightTest()
    {

        HomePage home = new HomePage(driver);

        home.selectDeparture("Boston");
        home.selectDestination("London");
        home.clickFindFlights();


        FlightsPage flights = new FlightsPage(driver);

        boolean flightsVisible = flights.isFlightsDisplayed();

        System.out.println("Flights visible: " + flightsVisible);

        Assert.assertTrue(flightsVisible, "Flights list is not displayed");

        flights.chooseFirstFlight();



        PurchasePage purchase = new PurchasePage(driver);

        purchase.enterDetails();
        purchase.purchaseFlight();


    
        ConfirmationPage confirm = new ConfirmationPage(driver);

        String message = confirm.getConfirmationMessage();

        System.out.println("Actual confirmation message: " + message);

        Assert.assertTrue(message.contains("Thank you for your purchase"),
                "Booking confirmation message not displayed");

    }
}