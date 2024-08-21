package stepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.SignUpPage;
import testBase.BaseClass;
import utilities.DataReader;

import java.io.FileReader;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.javafaker.Faker;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps  {
	WebDriver driver;
	HomePage hp;
	SignUpPage sp;
	Properties p;
	public Logger logger;
	public ResourceBundle rb;
	public String br;
	
	List<HashMap<String,String>> datamap;

@Before	
public void setup() throws IOException
{
	//for logging
	logger=LogManager.getLogger(this.getClass());
	FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	p=new Properties();
	p.load(file);
	br=p.getProperty("browser");	
}
@After
public void TearDown(Scenario scenario)
{
	System.out.println("Scenario Status===>"+scenario.getStatus());
	if(scenario.isFailed())
	{
		byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png",scenario.getName());
	}
	driver.quit();
}
@Given("User Launch Browser")
public void user_launch_browser() 
{
	switch(br.toLowerCase())
	{
	case "chrome": driver=new ChromeDriver();
	break;
	case "edge": driver=new EdgeDriver();
	break;
	case "firefox": driver=new FirefoxDriver();
	break;
	default:
		throw new IllegalArgumentException("Unsupported Browser:  "+br);
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   
}

@Given("opens URL {string}")
public void opens_url(String string) 
{
 driver.get(string);
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 driver.manage().deleteAllCookies();
}

@When("User Navigates to login_Signup page")
public void user_navigates_to_login_signup_page() throws InterruptedException 
{
	hp=new HomePage(driver);
   hp.ClickOnLoginSignup();
   logger.info("User Clicked on Login/Signup Page");
   Thread.sleep(3000);

}

@When("user enters Name as {string} and Email as {string}")
public void user_enters_name_as_and_email_as(String name, String email)
{hp=new HomePage(driver);
  hp.EnterEmail(email);
  logger.info("User enter Email");
  hp.Entername(name);
  logger.info("User enters Name");

}

@When("click on Signup Button")
public void click_on_signup_button()
{hp=new HomePage(driver);
	  hp.ClickOnSignUp();
	  logger.info("User Clicks on Signup");
}


@Then("User Navigates to signup page")
public void user_navigates_to_signup_page() 
{
	 logger.info("User Navigates to Signup Page");
}

@Then("user Title  as {string} and  Name as {string} Password as {string} and Day of Birth as {string} Month of Birth as {string} Year of Birth as {string} First Name as {string} Last Name as {string} Company as {string} Address as {string} Address2 as {string} Country as {string} State as {string} City as {string} ZipCode as {string} Mobile Number as {string}")
public void user_title_as_and_name_as_password_as_and_confirm_p_wd_as_password_and_day_of_birth_as_month_of_birth_as_year_of_birth_as_first_name_as_last_name_as_company_as_address_as_address2_as_country_as_state_as_city_as_zip_code_as_mobile_number_as(String Title, String name, String pwd, String date, String month,String year, String fname, String lname, String company, String Address, String Address1, String country, String state, String city, String zip,  String num) throws InterruptedException 
{sp=new SignUpPage(driver);
   sp.SelectTitle(Title);
   logger.info("User Enters Title");
   sp.EnterName(name);
   logger.info("User Enters Name");
   sp.EnterPwd(pwd);
   logger.info("User Enters Password");
   sp.SelectDay(date);
   logger.info("User Enters Date");
   sp.SelectMonth(month);
   logger.info("User Enters Month");
   sp.SelectYear(year);
   logger.info("User Enters Year");
   sp.EnterFname(fname);
   logger.info("User Enters First Name");
   sp.EnterLname(lname);
   logger.info("User Enters Last Name");
   sp.EnterCompanyName(company);
   logger.info("User Enters Company");
   sp.EnterAddress1(Address);
   logger.info("User Enters Address");
   sp.EnterAddress2(Address1);
   logger.info("User Enters Address 1");
   sp.SelectCountry(country);
   logger.info("User Enters Country");
   sp.EnterState(state);
   logger.info("User Enters  STate");
   sp.EnterCity(city);
   logger.info("User Enters City");
   sp.EnterZipCode(zip);
   logger.info("User Enters Zipcode");
   sp.EnterMobileNumber(num);
   logger.info("User Enters Number");

}

@Then("clicks on Create Account")
public void clicks_on_create_account()  
{sp=new SignUpPage(driver);
	   sp.CLickCreateAccount();
	   logger.info("User Clicks on Create Account");
	  
}
@Then("Account is Created")
public void account_is_created() throws InterruptedException 
{
	sp=new SignUpPage(driver);
	 sp.AccountCreated();
	   logger.info("Account is Created Suxccesfully");
}
@When("user enters Name and Email with excel row {string}")
public void user_enters_name_and_email_with_excel_row(String rows) 
{
	  datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Data.xlsx","Sheet1");
	   int index=Integer.parseInt(rows)-1;
	   String name=datamap.get(index).get("First Name");
	   String email=datamap.get(index).get("Email Address");
	   hp=new HomePage(driver);
	   hp.EnterEmail(email);
	   logger.info("User enter Email");
	   hp.Entername(name);
	   logger.info("User enters Name");
	  

}


@Then("user Title and Name and Password and Day of Birth and Month of Birth and Year of Birth and First Name and Last Name and Company and Address and Address2 and Country and State and City and ZipCode and Mobile Number with excel row {string}")
public void user_title_and_name_and_password_and_day_of_birth_and_month_of_birth_and_year_of_birth_and_first_name_and_last_name_and_company_and_address_and_address2_and_country_and_state_and_city_and_zip_code_and_mobile_number_with_excel_row(String rows) throws InterruptedException 
{
	try {
	
   datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Data.xlsx","Sheet1");
   int index=Integer.parseInt(rows)-1;
   String fname=datamap.get(index).get("First Name");
   String Title=datamap.get(index).get("Gender");
   String name=datamap.get(index).get("First Name");
   String pwd=datamap.get(index).get("Password");
   String date=datamap.get(index).get("D");
   String month=datamap.get(index).get("M");
   String year=datamap.get(index).get("Y");
   String lname=datamap.get(index).get("Last Name");
   String company="Company";
   String Address=datamap.get(index).get("Address");
   String Address1=datamap.get(index).get("Address 2");
   String country=datamap.get(index).get("Country");
   String state=datamap.get(index).get("State");
   String city=datamap.get(index).get("City");
   String zip=datamap.get(index).get("ZipCode");
   String num=datamap.get(index).get("Mobile Number");  
   
   sp=new SignUpPage(driver);
   sp.SelectTitle(Title);
   logger.info("User Enters Title");
   sp.EnterName(name);
   logger.info("User Enters Name");
   Thread.sleep(1000);
   sp.EnterPwd(pwd);
   logger.info("User Enters Password");
   Thread.sleep(5000);
   sp.SelectDay(date);
   logger.info("User Enters Date");
   Thread.sleep(5000);
   sp.SelectMonth(month);
   logger.info("User Enters Month");
   Thread.sleep(5000);
   sp.SelectYear(year);
   logger.info("User Enters Year");
   Thread.sleep(1000);
   sp.EnterFname(fname);
   logger.info("User Enters First Name");
   Thread.sleep(1000);
   sp.EnterLname(lname);
   logger.info("User Enters Last Name");
   Thread.sleep(1000);
   sp.EnterCompanyName(company);
   logger.info("User Enters Company");
   Thread.sleep(1000);
   sp.EnterAddress1(Address);
   logger.info("User Enters Address");
   Thread.sleep(1000);
   sp.EnterAddress2(Address1);
   logger.info("User Enters Address 1");
   Thread.sleep(1000);
   sp.SelectCountry(country);
   logger.info("User Enters Country");
   Thread.sleep(1000);
   sp.EnterState(state);
   logger.info("User Enters  STate");
   Thread.sleep(1000);
   sp.EnterCity(city);
   logger.info("User Enters City");
   Thread.sleep(1000);
   sp.EnterZipCode(zip);
   logger.info("User Enters Zipcode");
   Thread.sleep(1000);
   sp.EnterMobileNumber(num);
   logger.info("User Enters Number");
   Thread.sleep(1000);
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		
	}
}


}
