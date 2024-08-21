package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

	public SignUpPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement Mr_btn;
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement Mrs_btn;
	@FindBy(xpath="//input[@id='name']")
	WebElement Name_txt;
	@FindBy(xpath="//input[@id='password']")
	WebElement Pwd_txt;
	@FindBy(xpath="//select[@id='days']")
	WebElement Day_drp;
	@FindBy(xpath="//select[@id='months']")
	WebElement Month_drp;
	@FindBy(xpath="//select[@id='years']")
	WebElement Years_drp;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement Fname_txt;
	@FindBy(xpath="//input[@id='last_name']")
	WebElement Lname_txt;
	@FindBy(xpath="//input[@id='company']")
	WebElement Company_txt;
	@FindBy(xpath="//input[@id='address1']")
	WebElement Address1_txt;
	@FindBy(xpath="//input[@id='address2']")
	WebElement Address2_txt;
	@FindBy(xpath="//select[@id='country']")
	WebElement Country_drp;
	@FindBy(xpath="//input[@id='state']")
	WebElement State_txt;
	@FindBy(xpath="//input[@id='city']")
	WebElement City_txt;
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement ZipCode;
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement Mno_txt;
	@FindBy(xpath="//button[normalize-space()='Create Account']")
	WebElement CreateAccount_btn;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement Logout_btn;
	
	/*public void SelectMrTitle()
	{
		Mr_btn.click();
	}
	public void SelectMrsTitle()
	{
		Mrs_btn.click();
	}*/
	public void SelectTitle(String s)
	{
		if(s.equals("Mr."))
		{
			Mr_btn.click();
		}
		else
		{
			Mrs_btn.click();
		}
	}
	public void EnterName(String name)
	{
		Name_txt.sendKeys(name);
	}
	public void EnterPwd(String pwd)
	{
		Pwd_txt.sendKeys(pwd);
	}
	public void SelectDay(String day)
	{
		Select s=new Select(Day_drp);
		Day_drp.click();
		s.selectByVisibleText(day);
	}
	public void SelectMonth(String month)
	{
		Select s=new Select(Month_drp);
		Month_drp.click();
		s.selectByVisibleText(month);
	}
	public void SelectYear(String year)
	{
		Select s=new Select(Years_drp);
		Years_drp.click();
		s.selectByVisibleText(year);
	}
	public void EnterFname(String fname)
	{
		Fname_txt.sendKeys(fname);
	}
	public void EnterLname(String lname)
	{
		Lname_txt.sendKeys(lname);
	}
	public void EnterCompanyName(String n)
	{
		Company_txt.sendKeys(n);
	}
	public void EnterAddress1(String n)
	{
		Address1_txt.sendKeys(n);
	}
	public void EnterAddress2(String a)
	{
		Address2_txt.sendKeys(a);
	}
	public void SelectCountry(String co)
	{
		Select s=new Select(Country_drp);
		s.selectByVisibleText(co);
	}
	public void EnterState(String n)
	{
		State_txt.sendKeys(n);
	}
	public void EnterCity(String c) 
	{
	City_txt.sendKeys(c);	
	}
	public void EnterZipCode(String z)
	{
		ZipCode.sendKeys(z);
	}
	public void EnterMobileNumber(String n)
	{
		Mno_txt.sendKeys(n);
	}
	public void CLickCreateAccount()
	{
		CreateAccount_btn.click();
	}
	public void AccountCreated() throws InterruptedException
	{
		if(driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).isDisplayed())
		{
			System.out.println("Account Created Succesfully");
			driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
			Thread.sleep(2000);
			Logout_btn.click();
		}
		else
		{
			System.out.println("Account Not Created");
		}
	}
	
}
