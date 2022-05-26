package GoPadelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoPadelLadiesTimingsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"leftsidebar\"]/div/ul/li[2]/a")
	WebElement Bookings;
	
	@FindBy(css = "a[title='Ladies Timing']")
	WebElement LadiesTime;
	
	@FindBy(id = "ddlPadels")
	WebElement selectpadel;

	@FindBy(id = "ddlPadelsBranches")
	WebElement selectbranch;

	@FindBy(id = "ddlCourts")
	WebElement courtName;

	@FindBy(id = "txtstartdate")
	WebElement StartDate;

	@FindBy(id = "txtenddate")
	WebElement EndDate;

	@FindBy(css = "div[class='dtp'] .dtp-btn-ok")
	WebElement OkButton;
	
	@FindBy(xpath = "(//td[@data-date='31'])[2]")
	WebElement date;
	
	@FindBy(id = "btnBlockTimeSearch")
	WebElement LadiesTimesearch;

	@FindBy(tagName = "tbody")
	WebElement LadiesTimedata;

	@FindBy(id = "btnBlockTimeAdd")
	WebElement LadiesTimeAdd;
	
	@FindBy(css = "span[role='combobox']")
	WebElement CourtBox;
	
	public GoPadelLadiesTimingsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToLadiesTime() {
		
		Assert.assertEquals(true, Bookings.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Bookings is displayed ");

		Actions action = new Actions(driver);
		action.moveToElement(Bookings).perform();
		
		Assert.assertEquals(true, LadiesTime.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Block Timings is displayed");
		LadiesTime.click();
	
	}
	
	public void viewBlockTime() {

		Select padleselect = new Select(selectpadel);
		selectpadel.click();

		padleselect.selectByVisibleText("Anandu Padel");

		Select branchselect = new Select(selectbranch);
		selectbranch.click();

		branchselect.selectByVisibleText("Anandu branch");

		Select CourtSelect = new Select(courtName);
		courtName.click();

		CourtSelect.selectByVisibleText("Court 1");

		Assert.assertEquals(true, StartDate.isDisplayed());
		Assert.assertEquals(true, EndDate.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Start Sate is displayed");
		System.out.println(" > End Sate is displayed");

		StartDate.click();
		System.out.println("------------------------------------------------");
		System.out.println("Start Date is: " + StartDate.getAttribute("value"));
		OkButton.click();

		EndDate.click();
		date.click();
		System.out.println("------------------------------------------------");
		System.out.println("End Date is: " + EndDate.getAttribute("value"));
		OkButton.click();

		Assert.assertEquals(true, LadiesTimesearch.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Ladies Time search button is displayed");
		LadiesTimesearch.click();

		System.out.println("------------------------------------------------");
		System.out.println(" > Ladies Timings are:  ");
		System.out.println(LadiesTimedata.getAttribute("innerText"));

	}
	
	public void addAblockTime() throws InterruptedException {
		// TODO Auto-generated method stub
		Assert.assertEquals(true, LadiesTimeAdd.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Block Time Add button is displayed");

		LadiesTimeAdd.click();

		Select branchselect = new Select(selectbranch);
		selectbranch.click();

		branchselect.selectByVisibleText("Anandu branch");
		
		Thread.sleep(2000);

		Assert.assertEquals(true, CourtBox.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Court name box is displayed");

	}

}
