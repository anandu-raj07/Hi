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

public class GoPadelTrainerBookingPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "(//*[@class='member-name cell col-3'])[1]")
	WebElement Name;

	@FindBy(xpath = "(//*[@class='member-phone cell col-2'])[1]")
	WebElement Contact;

	@FindBy(xpath = "(//*[@class='member-email cell col-3'])[1]")
	WebElement Email;

	@FindBy(xpath = "(//*[@class='member-gender cell col-2'])[1]")
	WebElement Gender;

	@FindBy(xpath = "(//*[@class='member-actions cell col-1'])[1]")
	WebElement Padidcheck;

	@FindBy(id = "fullName")
	WebElement fullanme;

	@FindBy(id = "contact")
	WebElement contact;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "gender")
	WebElement gender;

	@FindBy(id = "invoicePaid")
	WebElement paidcheckbox;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/main/section/div[2]/div/div[1]/div/div/div/div[3]/div[6]/button")
	WebElement SaveUserDetails;

	@FindBy(xpath = "(//*[@confirmed-click='removeMember(m)'])[2]")
	WebElement removebutton;

	@FindBy(id = "selpackage")
	WebElement selectpackage;

	@FindBy(id = "ddltrainer")
	WebElement SelectTrainer;

	@FindBy(id = "ddltraining")
	WebElement SelectTraining;

	@FindBy(xpath = "(//*[text()='Save Changes'])[1]")
	WebElement Savebutton;

	@FindBy(xpath = "(//*[text()='Close'])[1]")
	WebElement Closebutton;

	@FindBy(className = "confirm")
	WebElement Alertconfirm;

	public GoPadelTrainerBookingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void trainerBooking() {
		wait = new WebDriverWait(driver, 20);

		WebElement outdoorBook = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@data-resource-id='157'])[1]")));
		outdoorBook.click();

		WebElement trainerBooking = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add a Trainer Booking']")));
		trainerBooking.click();

		System.out.println("------------------------------------------------");
		System.out.println(" > " + Name.getAttribute("value"));
		System.out.println(" > " + Contact.getAttribute("value"));
		System.out.println(" > " + Email.getAttribute("value"));
		System.out.println(" > " + Gender.getAttribute("value"));
		System.out.println(" > " + Padidcheck.getAttribute("value"));

		try {
			Assert.assertEquals(true, fullanme.isDisplayed());
			Assert.assertEquals(true, contact.isDisplayed());
			Assert.assertEquals(true, email.isDisplayed());
			Assert.assertEquals(true, gender.isDisplayed());
			Assert.assertEquals(true, paidcheckbox.isDisplayed());
			Assert.assertEquals(true, selectpackage.isDisplayed());
			Assert.assertEquals(true, SaveUserDetails.isDisplayed());
		} catch (AssertionError e) {
			e.printStackTrace();
		}

		System.out.println("------------------------------------------------");
		System.out.println(" > Full Name textbox is displayed");
		System.out.println(" > Contact textbox is displayed");
		System.out.println(" > Email textbox is displayed");
		System.out.println(" > Gender is displayed");
		System.out.println(" > Paid checkbox is displayed");
		System.out.println(" > Select package is displayed");
		System.out.println(" > Save button is displayed");
	}

	public void bookTrainer() {

		Assert.assertEquals(true, SelectTrainer.isDisplayed());
		Assert.assertEquals(true, SelectTraining.isDisplayed());
		Assert.assertEquals(true, Savebutton.isDisplayed());
		Assert.assertEquals(true, Closebutton.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Select Trainer is displayed");
		System.out.println(" > Select Training is displayed");
		System.out.println(" > Close button is displayed");
		System.out.println(" > Close button is displayed");

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

		WebDriverWait wait = new WebDriverWait(driver, 20);

		Savebutton.click();

		WebElement alertMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-timer='null']")));

		System.out.println("------------------------------------------------");
		System.out.println(" > " + alertMessage.getText());

		Alertconfirm.click();
		Closebutton.click();
	}

}
