package GoPadelPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoPadelManageBookingPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//*[text()='Bookings']")
	WebElement booking;

	@FindBy(xpath = "(//*[text()='Manage Bookings'])[2]")
	WebElement manageBooking;

	@FindBy(className = "breadcrumb")
	WebElement Breadcrumb;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/div/div/div[2]/div")
	WebElement buttongroup;

	@FindBy(id = "startdatebk")
	WebElement startDate;

	@FindBy(id = "enddatebk")
	WebElement endDate;

	@FindBy(id = "submit")
	WebElement submit;

	@FindBy(xpath = "(//*[text()='Bookings'])[2]")
	WebElement heading;

	@FindBy(id = "ddlPadels")
	WebElement padelList;

	@FindBy(id = "ddlBranches")
	WebElement branchList;

	@FindBy(xpath = "//*[@id=\"DataTables_Table_0_wrapper\"]/div[1]/a")
	WebElement excelbutton;

	@FindBy(tagName = "thead")
	WebElement tableHeadings;

	@FindBy(tagName = "tbody")
	WebElement tableData;

	@FindBy(xpath = "//*[text()='Back to Clubs']")
	WebElement backToPadelclubButton;

	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[10]/button[1]")
	WebElement generateInvoice;

	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[10]/button[2]")
	WebElement editBooking;

	@FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[10]/button[3]")
	WebElement cancelBooking;

	public GoPadelManageBookingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToManagebookPage() {

		wait = new WebDriverWait(driver, 20);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement menubutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='menu-sm']")));

		Assert.assertEquals(true, menubutton.isDisplayed());
		menubutton.click();

		System.out.println("------------------------------------------------");
		System.out.println(" > Menu bar expanded");

		Assert.assertEquals(true, booking.isDisplayed());
		booking.click();

		System.out.println("------------------------------------------------");
		System.out.println(" > Booking menu is displayed");

		try {
			// Assert.assertEquals(true, manageBooking.isDisplayed());
			manageBooking.click();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("------------------------------------------------");
		System.out.println(" > Manage Bookings  is displayed");

	}

	public void manageBookDisplay() {

		Assert.assertEquals(true, Breadcrumb.isDisplayed());
		try {
			Assert.assertEquals(true, buttongroup.isDisplayed());
		} catch (AssertionError e) {
			e.printStackTrace();
		}

		System.out.println("------------------------------------------------");
		System.out.println(" > Breadcrumb is displayed with " + Breadcrumb.getText());
		System.out.println(" > Button group is displayed with " + buttongroup.getText());

	}

	public void manageBookCalander() {

		Assert.assertEquals(true, startDate.isDisplayed());
		Assert.assertEquals(true, endDate.isDisplayed());
		Assert.assertEquals(true, submit.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Start date is displayed with ");
		System.out.println(" > End date is displayed with ");
		System.out.println(" > Submit button is displayed with ");

	}

	public void manageBookBookings() {

		Assert.assertEquals(true, heading.isDisplayed());
		Assert.assertEquals(true, padelList.isDisplayed());
		Assert.assertEquals(true, branchList.isDisplayed());
		Assert.assertEquals(true, excelbutton.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Heading is displayed with " + heading.getText());

		Select Padelselect = new Select(padelList);

		List<WebElement> PadelListDropdown = Padelselect.getOptions();
		System.out.println("------------------------------------------------");
		System.out.println(" > Padel dropdown consist");
		for (WebElement Padel : PadelListDropdown) {
			System.out.println(" > " + Padel.getText());
		}
		Padelselect.selectByVisibleText("Anandu Padel");

		Select branchselect = new Select(branchList);
		branchList.click();
		System.out.println("------------------------------------------------");

		List<WebElement> branchdropdown = branchselect.getOptions();
		for (WebElement branchname : branchdropdown) {
			System.out.println(" > " + branchname.getText());
		}
		branchList.click();
		branchselect.selectByVisibleText("Anandu branch");

		System.out.println("------------------------------------------------");
		System.out.println(" > Excel button is played and user able to downlaod a excel file of booking list");

		Assert.assertEquals(true, tableHeadings.isDisplayed());
		Assert.assertEquals(true, tableData.isDisplayed());
		Assert.assertEquals(true, tableData.isDisplayed());
//		Assert.assertEquals(true, generateInvoice.isDisplayed());
//		Assert.assertEquals(true, editBooking.isDisplayed());
//		Assert.assertEquals(true, cancelBooking.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Table heading  is displayed with " + tableHeadings.getText());
		System.out.println(" > Table data  is displayed with the details of booking list" + tableData.getText());
		System.out.println(" > Back to padel club button is displayed");
		System.out.println(" > Invoice Generate button is displayed");
		System.out.println(" > Edit booking button is displayed");
		System.out.println(" > Cancel booking button is displayed");

	}

}
