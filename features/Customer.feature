Feature: Customer

  Background:
    Given user launch browser
    When user opens url "http://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then user can view dashboard

  @sanity
  Scenario: Add a New Customer
    When user click on customers menu
    And click on customers menu item
    And click on add new button
    Then user can view add new customer page
    When user enter customer info
    And click on save button
    Then user can view confirmation message "The new customer has been added successfully."
    And close browser

  @regression @sanity
  Scenario: Search Customer by EmailId
    When user click on customers menu
    And click on customers menu item
    And enter customer email
    When user click on search button
    Then user should find email in the table
    And close browser

  @regression
  Scenario: Search Customer by Name
    When user click on customers menu
    And click on customers menu item
    And enter customer firstname as "Victoria"
    And enter customer lastname as "Terces"
    When user click on search button
    Then user should find Name as "Victoria Terces" in the table
    And close browser

