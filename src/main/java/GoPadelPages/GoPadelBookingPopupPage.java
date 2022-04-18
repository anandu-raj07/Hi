package GoPadelPages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoPadelBookingPopupPage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/main/section/div[2]/div/div[1]/div/div/div/div[1]/div[1]")
	WebElement Name;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/main/section/div[2]/div/div[1]/div/div/div/div[1]/div[2]")
	WebElement Contact;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/main/section/div[2]/div/div[1]/div/div/div/div[1]/div[3]")
	WebElement Email;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/main/section/div[2]/div/div[1]/div/div/div/div[1]/div[4]")
	WebElement Gender;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/main/section/div[2]/div/div[1]/div/div/div/div[1]/div[5]")
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

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/main/section/div[2]/div/div[1]/div/div/div/div[3]/div[6]/button")
	WebElement removebutton;

	@FindBy(id = "selpackage")
	WebElement selectpackage;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/main/section/div[2]/div/div[2]/div/div[2]/div[1]/div[3]/button")
	WebElement startTime;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/main/section/div[2]/div/div[2]/div/div[2]/div[1]/div[5]/button")
	WebElement endTime;

	@FindBy(id = "th-15")
	WebElement H_NewStartTime;

	@FindBy(id = "th-18")
	WebElement H_NewEndTime;

	@FindBy(xpath = "(//*[text()='Save Changes'])[1]")
	WebElement Savebutton;

	@FindBy(className = "confirm")
	WebElement Alertconfirm;

	@FindBy(id = "txtcouponcode")
	WebElement coupontxt;

	@FindBy(id = "btnvalidatediscount")
	WebElement Applybutton;

	@FindBy(xpath = "(//*[text()='Close'])[1]")
	WebElement Closebutton;

	public GoPadelBookingPopupPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void bookingPopup() {

		System.out.println("------------------------------------------------");
		System.out.println(" > " + Name.getText());
		System.out.println(" > " + Contact.getText());
		System.out.println(" > " + Email.getText());
		System.out.println(" > " + Gender.getText());
		System.out.println(" > " + Padidcheck.getText());

		Assert.assertEquals(true, fullanme.isDisplayed());
		Assert.assertEquals(true, contact.isDisplayed());
		Assert.assertEquals(true, email.isDisplayed());
		Assert.assertEquals(true, gender.isDisplayed());
		Assert.assertEquals(true, paidcheckbox.isDisplayed());
		Assert.assertEquals(true, selectpackage.isDisplayed());
		Assert.assertEquals(true, SaveUserDetails.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Full Name textbox is displayed");
		System.out.println(" > Contact textbox is displayed");
		System.out.println(" > Email textbox is displayed");
		System.out.println(" > Gender is displayed");
		System.out.println(" > Paid checkbox is displayed");
		System.out.println(" > Select package is displayed");
		System.out.println(" > Save button is displayed");

	}

	public void addABooking() {

		Assert.assertEquals(true, Savebutton.isDisplayed());
		Assert.assertEquals(true, Closebutton.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Save button is displayed");
		System.out.println(" > Close button is displayed");

		fullanme.sendKeys("Michael");

		String attribute = fullanme.getAttribute("value");
		System.out.println("------------------------------------------------");
		System.out.println(" > Entered value:" + attribute);

		if (attribute.contains("Michael")) {
			System.out.println("------------------------------------------------");
			System.out.println(" > Name is a text field");
		}

		else {
			System.out.println("------------------------------------------------");
			System.out.println(" > Name is not a text field");
		}

		email.sendKeys("anan@mail.com");

		String Attribute = email.getAttribute("value");
		System.out.println("------------------------------------------------");
		System.out.println(" > Entered value:" + Attribute);

		if (Attribute.contains("anan@mail.com")) {
			System.out.println("------------------------------------------------");
			System.out.println(" > Email is a text field");
		}

		else {
			System.out.println("------------------------------------------------");
			System.out.println(" > Email is not a text field");
		}

		contact.sendKeys("675635");

		String phAttribute = contact.getAttribute("value");
		System.out.println("------------------------------------------------");
		System.out.println(" > Entered value:" + phAttribute);

		if (phAttribute.contains("675635")) {
			System.out.println("------------------------------------------------");
			System.out.println(" > PhoneNo is a numeric field");
		}

		else {
			System.out.println("------------------------------------------------");
			System.out.println(" > PhoneNo is not a numeric field");
		}

		Select genderselect = new Select(gender);

		List<WebElement> Genderdropdown = genderselect.getOptions();
		System.out.println("------------------------------------------------");
		System.out.println(" > Gender dropdown consist");
		for (WebElement Gender : Genderdropdown) {
			System.out.println(" > " + Gender.getText());
		}
		genderselect.selectByIndex(0);

		SaveUserDetails.click();

		startTime.click();
		H_NewStartTime.click();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement Okbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='OK'])[5]")));

		Actions acn = new Actions(driver);
		acn.moveToElement(Okbutton).click().build().perform();
		acn.moveToElement(Okbutton).click().build().perform();

		endTime.click();
		H_NewEndTime.click();

		WebElement OKbutton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='OK'])[6]")));

		acn.moveToElement(OKbutton).click().build().perform();
		acn.moveToElement(OKbutton).click().build().perform();

		Savebutton.click();

		WebElement alertMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[21]")));

		System.out.println("------------------------------------------------");
		System.out.println(" > " + alertMessage.getText());

		Alertconfirm.click();

	}

	public void removeAuser() {

		Assert.assertEquals(true, removebutton.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Remove button is displayed");

		removebutton.click();

		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		alert.accept();

		System.out.println("------------------------------------------------");
		System.out.println(" > User record is not deleted");

	}

	public void couponCodevalidation() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		Assert.assertEquals(true, coupontxt.isDisplayed());
		Assert.assertEquals(true, Applybutton.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Coupon textbox is displayed");
		System.out.println(" > Apply button is displayed");

		coupontxt.sendKeys("34567");
		Applybutton.click();

		WebElement alertMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[21]")));

		System.out.println("------------------------------------------------");
		System.out.println(" > " + alertMessage.getText());

		Alertconfirm.click();

		Closebutton.click();

	}

	public void clientDetailsblankValidation() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement outdoorBook = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id=\"calendar1\"]/div[2]/div[1]/table/tbody/tr[1]/td/div/div/div/table/tbody/tr/td[2]")));
		outdoorBook.click();

		WebElement addAbooking = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Add a Booking'])[1]")));
		addAbooking.click();

		SaveUserDetails.click();
		System.out.println("------------------------------------------------");
		System.out.println(" > Warning message should be dispalyed");

		Savebutton.click();

		WebElement alertMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[21]")));

		System.out.println("------------------------------------------------");
		System.out.println(" > " + alertMessage.getText());

		Alertconfirm.click();
		Closebutton.click();

	}

}
