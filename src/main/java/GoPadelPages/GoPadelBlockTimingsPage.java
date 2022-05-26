package GoPadelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoPadelBlockTimingsPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//*[@id=\"leftsidebar\"]/div/ul/li[2]/a")
	WebElement Bookings;

	@FindBy(xpath = "(//*[text()='Block Timings'])[2]")
	WebElement BlockTimings;

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
	WebElement BlockTimeSearch;

	@FindBy(tagName = "tbody")
	WebElement BlockTimeData;

	@FindBy(id = "btnBlockTimeAdd")
	WebElement BlockTimeAdd;

	@FindBy(css = "span[role='combobox']")
	WebElement CourtBox;

	public GoPadelBlockTimingsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToBlockTime() {

		Assert.assertEquals(true, Bookings.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Bookings is displayed ");

		Actions action = new Actions(driver);
		action.moveToElement(Bookings).perform();

		Assert.assertEquals(true, BlockTimings.isDisplayed());
		System.out.println("------------------------------------------------");
		System.out.println(" > Block Timings is displayed");
		BlockTimings.click();
	}

	public void viewBlockTime() throws InterruptedException {

		Select padleselect = new Select(selectpadel);
		selectpadel.click();

		padleselect.selectByVisibleText("Anandu Padel");

		Select branchselect = new Select(selectbranch);
		selectbranch.click();
		
		Thread.sleep(2000);

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

		Assert.assertEquals(true, BlockTimeSearch.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Block Time search button is displayed");
		BlockTimeSearch.click();

		System.out.println("------------------------------------------------");
		System.out.println(" > Block Timings are:  ");
		System.out.println(BlockTimeData.getAttribute("innerText"));

	}

	public void addAblockTime() {
		// TODO Auto-generated method stub
		Assert.assertEquals(true, BlockTimeAdd.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Block Time Add button is displayed");

		BlockTimeAdd.click();

		Select branchselect = new Select(selectbranch);
		selectbranch.click();

		branchselect.selectByVisibleText("Anandu branch");

		Assert.assertEquals(true, CourtBox.isDisplayed());

		System.out.println("------------------------------------------------");
		System.out.println(" > Court name boxis displayed");

	}

}
