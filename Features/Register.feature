Feature: Register with valid Credentials

@sanity
  Scenario: Successful Register with valid Credentials
    Given User Launch Browser
    And opens URL "https://automationexercise.com/"
    When User Navigates to login_Signup page
    And user enters Name as "RObin Sharma" and Email as "robiffnh@gmail.com" 
    And click on Signup Button
    Then User Navigates to signup page
    And user Title  as "Mr" and  Name as "Robb" Password as "test123" and Day of Birth as "6" Month of Birth as "June" Year of Birth as "1999" First Name as "Haye" Last Name as "Sing" Company as "Deloitte" Address as "Address 123, Brampton, ON" Address2 as "Caledon, ON" Country as "India" State as "Ontario" City as "Caledon" ZipCode as "143505" Mobile Number as "1234568"
    Then clicks on Create Account
    Then Account is Created
     
  