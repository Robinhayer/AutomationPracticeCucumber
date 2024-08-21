Feature: Register with valid Credentials

@sanity
Scenario Outline: Successful Register with valid Credentials
  Given User Launch Browser
  And opens URL "https://automationexercise.com/"
  When User Navigates to login_Signup page
  And user enters Name and Email with excel row "<row_index>"
  And click on Signup Button
  Then User Navigates to signup page
  And user Title and Name and Password and Day of Birth and Month of Birth and Year of Birth and First Name and Last Name and Company and Address and Address2 and Country and State and City and ZipCode and Mobile Number with excel row "<row_index>"
  Then clicks on Create Account
  Then Account is Created

  Examples:
    | row_index |
    | 1         |
    | 2         |
    | 3         |

 
    


