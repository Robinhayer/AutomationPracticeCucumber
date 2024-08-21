Feature: Register with valid Credentials using Excel Sheet

@sanity
  Scenario: Successful Register with valid Credentials
    Given User Launch Browser
    And opens URL "https://automationexercise.com/"
    When User Navigates to login_Signup page
    And user enters Name as "<name>" and Email as "<Email Address>" 
    And click on Signup Button
    Then User Navigates to signup page
    And user Title  as "<Gender>" and  Name as "<name>" Password as "<Password>" and Day of Birth as "<Birth Day>" Month of Birth as "<Birth Month>" Year of Birth as "<Birth Year>" First Name as "<First Name>" Last Name as "<Last Name>" Company as "Deloitte" Address as "<Address 1>" Address2 as "<Address 2>" Country as "<Country>" State as "<State>" City as "<City>" ZipCode as "<Zip Code>" Mobile Number as "<Mobile Number>"
    Then clicks on Create Account
    Then Account is Created
    
    Examples:
    |name          |First Name	|Last Name|Email Address     |Password	|Gender|Birth Day|Birth Month|Birth Year|	Address 1 |	Address 2|	Country|	State |	City|	Zip Code|	Mobile Number|
    |John Doe      |John      	|Doe	    |john.doe1@test.com|password	|Mr.   |1	      |July       |1990	     |123 Main St	|Apt 4B    |	India	 |New York|  NY |	10001	  |1234567890    |
