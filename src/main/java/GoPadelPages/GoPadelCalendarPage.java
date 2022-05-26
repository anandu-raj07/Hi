package GoPadelPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoPadelCalendarPage {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/div/div/div[1]/ul")
	WebElement breadcrumb;

	@FindBy(id = "ddlPadel")
	WebElement selectpadel;

	@FindBy(id = "ddPadelBranch")
	WebElement selectbranch;

	@FindBy(xpath = "//*[@id=\"divdynemicmenu\"]/div[3]/div/div/div[4]/div")
	WebElement buttongroup;

	@FindBy(xpath = "//*[@id=\"calendar1\"]/div[2]/div[1]/table/thead/tr/th/div/div/table/thead/tr")
	WebElement courttype;

	@FindBy(xpath = "(//td[@data-resource-id='157'])[1]")
	WebElement outdoorbooking;
	
	@FindBy(id = "booking-context-menu")
	WebElement bookingcontextmenu;

	@FindBy(xpath = "(//*[text()='Add a Booking'])[1]")
	WebElement addbooking;

	public GoPadelCalendarPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getUrl() {

		return driver.getCurrentUrl();
	}

	public void calendarPageDetails() {

		Assert.assertEquals(true, breadcrumb.isDisplayed());
		Assert.assertEquals(true, selectpadel.isDisplayed());
		Assert.assertEquals(true, selectbranch.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Breadcrumb is displayed");
		System.out.println(" > Select Padel  is displayed");
		System.out.println(" > Select Branch  is displayed");

	}

	public void selectPadel() {

		Select padleselect = new Select(selectpadel);
		selectpadel.click();
		System.out.println("------------------------------------------------");

		List<WebElement> padledropdown = padleselect.getOptions();
		for (WebElement padelname : padledropdown) {
			System.out.println(" > " + padelname.getText());
		}
		selectpadel.click();
		padleselect.selectByVisibleText("Anandu Padel");

	}

	public void selectBranch() {

		Select branchselect = new Select(selectbranch);
		selectbranch.click();
		System.out.println("------------------------------------------------");

		List<WebElement> branchdropdown = branchselect.getOptions();
		for (WebElement branchname : branchdropdown) {
			System.out.println(" > " + branchname.getText());
		}
		selectbranch.click();
		branchselect.selectByVisibleText("Anandu branch");
	}

	public void buttongroup() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		Assert.assertEquals(true, buttongroup.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Button group is displayed with " + buttongroup.getText());
		
		WebElement date = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTodaysDate")));
		WebElement previousday = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Prev']")));
		WebElement nextday = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
				
		System.out.println("------------------------------------------------");
		System.out.println(" > Current day " + date.getText());
		
		previousday.click();
		System.out.println("------------------------------------------------");
		System.out.println(" > Calendar date is changed to previous day " + date.getText());
		
		nextday.click();
		nextday.click();
		System.out.println("------------------------------------------------");
		System.out.println(" > Calendar date is changed to next day " + date.getText());
		
		previousday.click();

	}

	public void padelcourt() {

		Assert.assertEquals(true, courttype.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Padel Court type is displayed with " + courttype.getText());

	}

	public void outdoorBooking() {

		Assert.assertEquals(true, outdoorbooking.isDisplayed());
		outdoorbooking.click();

		System.out.println("------------------------------------------------");
		System.out.println(" > Outdoor booking is displayed with " + "\n" + bookingcontextmenu.getText());
		Assert.assertEquals(true, addbooking.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Add a booking is displayed");
		addbooking.click();

	}

}
