package GoPadelTest;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import GoPadelPages.GoPadelBookingPopupPage;
import GoPadelPages.GoPadelCalendarPage;
import GoPadelPages.GoPadelLoginPage;
import GoPadelPages.GoPadelTrainerBookingPage;
import TestScenario.GoPadelTestBase;

public class GoPadelTest extends GoPadelTestBase {

	GoPadelLoginPage loginPage;
	GoPadelCalendarPage calendarPage;
	GoPadelBookingPopupPage bookingPage;
	GoPadelTrainerBookingPage trainerBookPopup;

	// Log4j configuration
	private static final Logger log = LogManager.getLogger(GoPadelTest.class);

	@Test(priority = 0)
	public void bookingCalenderTest() {

		log.info("Verifying successful login.");

		loginPage = new GoPadelLoginPage(driver);

		GoPadelCalendarPage calendarPage = loginPage.login("admin", "Admin@12345");

		String ExpectedUrl = "https://gpv2.cadvil.com/bookings";
		String Actualurl = calendarPage.getUrl();

		log.info("Booking Calendar page is displayed.");
		log.info("expectedUrl-" + ExpectedUrl + " and actualUrl - " + Actualurl);
		Assert.assertEquals(ExpectedUrl, Actualurl);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		calendarPage.calendarPageDetails();
		calendarPage.selectPadel();
		calendarPage.selectBranch();
		calendarPage.buttongroup();
		calendarPage.padelcourt();
		calendarPage.outdoorBooking();

	}

	@Test(priority = 1)
	public void bookingPopupTest() {

		bookingPage = new GoPadelBookingPopupPage(driver);

		bookingPage.bookingPopup();
		bookingPage.addABooking();
		bookingPage.removeAuser();
		bookingPage.couponCodevalidation();
		bookingPage.clientDetailsblankValidation();

	}

	@Test(priority = 2)
	public void trainerBookingTest() {

		trainerBookPopup = new GoPadelTrainerBookingPage(driver);

		trainerBookPopup.trainerBooking();
		trainerBookPopup.bookTrainer();
	}

}
