Feature: Customer

Background: Below are the common steps for each scenario
   Given User Launch Chrome browser
   When User opens URL "https://admin-demo.nopcommerce.com/login"
   And User enters Email as "admin@yourstore.com" and Password as "admin"
   And Click on Login
   Then USer can view Dashboard

Scenario: Add new Customer
   
   When User click on customers Menu
   And click on customers Menu Item
   And click on Add new button
   Then User can view Add new customer page
   When User enter customer info
   And click on save button
   Then User can view confiramtion message "The new customer has been added successfully"
   And close browser
   
 Scenario: Search Customer by EMailID
   
   When User click on customers Menu
   And click on customers Menu Item
   And Enter customer EMail
   When Click on search button
   Then USer should found Email in the Search table
   And close browser
   
   Scenario: Search Customer by EMailID
   
   When User click on customers Menu
   And click on customers Menu Item
   And Enter customer FirstName
   And Enter customer LastName   
   When Click on search button
   Then USer should found Name in the Search table
   And close browser

