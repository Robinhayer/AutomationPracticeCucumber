package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//a[normalize-space()='Home']")
	WebElement Home_btn;
	@FindBy(xpath="//a[@href='/products']")
	WebElement Products_btn;
	@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
	WebElement Cart_btn;
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement Signup_Login_btn;
	@FindBy(xpath="//input[@placeholder='Name']")
	WebElement Name_txt;
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement Email_txt;
	@FindBy(xpath="//button[normalize-space()='Signup']")
	WebElement Signup_btn;

	
	public void ClickOnHome()
	{
		Home_btn.click();
	}
	public void ClickOnProducts()
	{
		Products_btn.click();
	}
	public void ClickOnLoginSignup()
	{
		Signup_Login_btn.click();
	}
	public void Entername(String name)
	{
		Name_txt.sendKeys(name);
	}
	public void EnterEmail(String email)
	{
		Email_txt.sendKeys(email);
	}
	public void ClickOnSignUp()
	{
		Signup_btn.click();
	}

}
