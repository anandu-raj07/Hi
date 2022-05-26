package GoPadelTest;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import GoPadelPages.GoPadelBlockTimingsPage;
import GoPadelPages.GoPadelBookingPopupPage;
import GoPadelPages.GoPadelCalendarPage;
import GoPadelPages.GoPadelLadiesTimingsPage;
import GoPadelPages.GoPadelLoginPage;
import GoPadelPages.GoPadelManageBookingPage;
import GoPadelPages.GoPadelRecurringBookingPopupPage;
import GoPadelPages.GoPadelTrainerBookingPage;
import TestScenario.GoPadelTestBase;

public class GoPadelTest extends GoPadelTestBase {

	GoPadelLoginPage loginPage;
	GoPadelCalendarPage calendarPage;
	GoPadelBookingPopupPage bookingPage;
	GoPadelTrainerBookingPage trainerBookPopup;
	GoPadelManageBookingPage managebookPage;
	GoPadelRecurringBookingPopupPage recurringPage;
	GoPadelBlockTimingsPage blockTimePage;
	GoPadelLadiesTimingsPage ladiesTimePage;

	// Log4j configuration
	private static final Logger log = LogManager.getLogger(GoPadelTest.class);

	@Test(priority = 0)
	public void bookingCalenderTest() {

		log.info("Verifying successful login.");

		loginPage = new GoPadelLoginPage(driver);

		GoPadelCalendarPage calendarPage = loginPage.login("admin", "Admin@12345");

		String ExpectedUrl = "https://staging.gopadel.ae/bookings";
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
	public void bookingPopupTest() throws InterruptedException {

		bookingPage = new GoPadelBookingPopupPage(driver);

		bookingPage.bookingPopup();
//		bookingPage.courtBooking();
		bookingPage.addABooking();
		bookingPage.removeAuser();
		bookingPage.couponCodevalidation();
		bookingPage.clientDetailsBlankValidation();

	}

	@Test(priority = 2)
	public void trainerBookingTest() {

		trainerBookPopup = new GoPadelTrainerBookingPage(driver);

		trainerBookPopup.trainerBooking();
		trainerBookPopup.bookTrainer();
	}

	@Test(priority = 3)
	public void recurringBookingTest() {

		recurringPage = new GoPadelRecurringBookingPopupPage(driver);

		recurringPage.recurringPage();
		recurringPage.recurringBookingPopup();
	}

	@Test(priority = 4)
	public void manageBookPageTest() {

		managebookPage = new GoPadelManageBookingPage(driver);

		managebookPage.navigateToManagebookPage();
		managebookPage.manageBookDisplay();
		managebookPage.manageBookCalander();
		managebookPage.manageBookBookings();
	}

	@Test(priority = 5)
	public void blockTimePageTest() throws InterruptedException {

		blockTimePage = new GoPadelBlockTimingsPage(driver);

		blockTimePage.navigateToBlockTime();
		blockTimePage.viewBlockTime();
		blockTimePage.addAblockTime();
	}
	
	@Test(priority = 6)
	public void ladiesTimePageTest() throws InterruptedException {

		ladiesTimePage = new GoPadelLadiesTimingsPage(driver);

		ladiesTimePage.navigateToLadiesTime();
		ladiesTimePage.viewBlockTime();
		ladiesTimePage.addAblockTime();
	}

}
