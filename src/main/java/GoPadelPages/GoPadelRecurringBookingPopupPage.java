package GoPadelPages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoPadelRecurringBookingPopupPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "(//*[@class='member-name cell col-3'])[2]")
	WebElement Name;

	@FindBy(xpath = "(//*[@class='member-phone cell col-2'])[2]")
	WebElement Contact;

	@FindBy(xpath = "(//*[@class='member-email cell col-3'])[2]")
	WebElement Email;

	@FindBy(xpath = "(//*[@class='member-gender cell col-2'])[2]")
	WebElement Gender;

	@FindBy(xpath = "(//*[@class='member-actions cell col-1'])[2]")
	WebElement Padidcheck;

	@FindBy(id = "fullName_Rec")
	WebElement fullanme;

	@FindBy(id = "contact_Rec")
	WebElement contact;

	@FindBy(id = "email_Rec")
	WebElement email;

	@FindBy(id = "gender_Rec")
	WebElement gender;

	@FindBy(id = "invoicePaid_Rec")
	WebElement paidcheckbox;

	@FindBy(css = "button[ng-click='addMemberRec()']")
	WebElement SaveUserDetails;

	@FindBy(css = "button[ng-click='CleareRecurrData()']")
	WebElement closeButton;

	@FindBy(xpath = "(//*[@class='modal-header']/child::span)[4]")
	WebElement courtName;

	@FindBy(xpath = "(//*[@class='modal-header']/child::span)[5]")
	WebElement Amount;

	@FindBy(id = "txtstartdate")
	WebElement StartDate;

	@FindBy(id = "txtenddate")
	WebElement EndDate;

	@FindBy(id = "Week")
	WebElement Week;

	@FindBy(xpath = "(//div[@class='booking-flags d-flex'])[4]")
	WebElement WeekDays;

	public GoPadelRecurringBookingPopupPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void recurringPage() {
		wait = new WebDriverWait(driver, 20);

		WebElement outdoorBook = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@data-resource-id='157'])[1]")));
		outdoorBook.click();

		WebElement recurringBooking = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Recurring Booking']")));
		recurringBooking.click();

	}

	public void recurringBookingPopup() {

		wait = new WebDriverWait(driver, 20);

		WebElement FullName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fullName_Rec")));

		Assert.assertEquals(true, FullName.isDisplayed());
		Assert.assertEquals(true, contact.isDisplayed());
		Assert.assertEquals(true, email.isDisplayed());
		Assert.assertEquals(true, gender.isDisplayed());
		Assert.assertEquals(true, paidcheckbox.isDisplayed());
		Assert.assertEquals(true, SaveUserDetails.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Full Name textbox is displayed");
		System.out.println(" > Contact textbox is displayed");
		System.out.println(" > Email textbox is displayed");
		System.out.println(" > Gender is displayed");
		System.out.println(" > Paid checkbox is displayed");
		System.out.println(" > Save button is displayed");

		System.out.println("------------------------------------------------");
		String name = "Anandu";

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd_hh:mm:ss:");
		long timeMilli = date.getTime();
		String strDate = dateFormat.format(date);
		String Name = name + strDate + timeMilli;

		fullanme.sendKeys(Name);

		String attribute = fullanme.getAttribute("value");
		System.out.println("------------------------------------------------");
		System.out.println(" > Entered value:" + attribute);

		if (attribute.contains(Name)) {
			System.out.println("------------------------------------------------");
			System.out.println(" > Name is a text field");
		}

		else {
			System.out.println("------------------------------------------------");
			System.out.println(" > Name is not a text field");
		}

		System.out.println("------------------------------------------------");
		String E_mail = "test@gmail.com";
		String Email = E_mail.replace("@", "+" + strDate + timeMilli + "@");

		email.sendKeys(Email);

		String Email_attribute = email.getAttribute("value");
		System.out.println("------------------------------------------------");
		System.out.println(" > Entered value:" + Email_attribute);

		if (Email_attribute.contains(Email)) {
			System.out.println("------------------------------------------------");
			System.out.println(" > Email is entered ");

		} else {
			System.out.println("------------------------------------------------");
			System.out.println(" > Please enter a valid Email ID");
		}

		System.out.println("------------------------------------------------");
		System.out.println(" > Enter the Conatact :");
		String Contact = "1234";
		String contacts = Contact + strDate + timeMilli;

		contact.sendKeys(contacts);

		String Ph_attribute = contact.getAttribute("value");
		System.out.println("------------------------------------------------");
		System.out.println(" > Entered value:" + Ph_attribute);

		if (Ph_attribute.contains(contacts)) {
			System.out.println("------------------------------------------------");
			System.out.println(" > Phone no is entered ");

		} else {
			System.out.println("------------------------------------------------");
			System.out.println(" > PhoneNo contains only numeric values");
		}
		Select genderselect = new Select(gender);

		List<WebElement> Genderdropdown = genderselect.getOptions();
		System.out.println("------------------------------------------------");
		System.out.println(" > Gender dropdown consist");
		for (WebElement Gender : Genderdropdown) {
			System.out.println(" > " + Gender.getText());
		}
		System.out.println("------------------------------------------------");
		genderselect.selectByVisibleText("Male");
		
		SaveUserDetails.click();

		Assert.assertEquals(true, courtName.isDisplayed());
		Assert.assertEquals(true, Amount.isDisplayed());
		Assert.assertEquals(true, StartDate.isDisplayed());
		Assert.assertEquals(true, EndDate.isDisplayed());
		Assert.assertEquals(true, Week.isDisplayed());
		Assert.assertEquals(true, WeekDays.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Court Name is displayed with" + courtName.getText());
		System.out.println(" > Court Amount is displayed with" + Amount.getText());
		System.out.println(" > Start Date is displayed");
		System.out.println(" > End Date is displayed");
		System.out.println(" > Week days is displayed with" + WeekDays.getText());
		System.out.println(" > Week is displayed");

		closeButton.click();

	}

}
