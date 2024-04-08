
@all
Feature: Property details


Scenario: On property details, check Age of building column has 5 values
Given user is on the property page
When user clicks on the age of building
Then user can see the 6 values 


Scenario Outline: On property details, check Age of building column has these options
Given user is on the property page
When user clicks on the age of building
Then user can see these options <option>
Examples:
|option| 
|"0 to 5 Years"|
|"5 to 10 Years"|
|"10 to 15 Years"|
|"15 to 20 Years"|
|"20 to 25 Years"|



@done
Scenario Outline: On property details, check 24/7 security drop-down has yes and no values
Given user is on the property page
When user clicks on  security 
Then user should be able to see <option>
Examples:
|option|
|"Yes"|
|"No"|



Scenario: On property details , check salaried person can  proceed
Given user is on the property page
When user enters all the necessary details
And user checks salaried person as "yes"
Then user can proceed 

Scenario: On property details, check non salaried person cannot proceed 
Given user is on the property page
When user enters all the necessary details
And user checks salaried person as "no"
Then user should get pop up "As Per The Terms and Conditions Your Home insurance Rejected"


 Scenario: On property details , check user is able to fill the property page details and can proceed
 Given user is on the property page
 When user enters all the necessary details
 And user can proceed
 Then user is navigated to "Premium Details" page
 
 
 @wip
 Scenario Outline: On Property details ,Verify the Current market value of property field validations in property details page
 Given user is on the property page
 When user gives wrong input Current Market <input>
 Then user should see error message "Please enter the Value min 100000"
 Examples:
 |input|
 |"1"|
 |"@##"|
 |"10000044$"|
 

