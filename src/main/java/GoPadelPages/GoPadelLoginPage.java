package GoPadelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;

public class GoPadelLoginPage {

	WebDriver driver;

	private static final Logger log = LogManager.getLogger(GoPadelLoginPage.class);

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement login;

	public GoPadelLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String uname) {
		username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		login.click();
	}
	

	public GoPadelCalendarPage login(String username, String password) {
		log.info("Logging with username - " + username + "  and password - " + password);
		setUsername(username);
		setPassword(password);
		clickLoginButton();
		System.out.println("------------------------------------------------");
		System.out.println(" > Successfully Log in to Go Padel");
		return new GoPadelCalendarPage(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
