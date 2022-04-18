package GoPadelPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

	@FindBy(xpath = "//*[@id=\"calendar1\"]/div[2]/div[1]/table/tbody/tr[1]/td/div/div/div/table/tbody/tr/td[2]")
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
		padleselect.selectByIndex(3);

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
		branchselect.selectByIndex(1);
	}

	public void buttongroup() {

		Assert.assertEquals(true, buttongroup.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Button group is displayed with " + buttongroup.getText());

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
