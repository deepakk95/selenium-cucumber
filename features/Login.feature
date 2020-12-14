Feature: Login

  @sanity
  Scenario: Successful Login with Valid Credentials
    Given user launch browser
    When user opens url "http://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on log out link
    Then page title should be "Your store. Login"
    And close browser

  @regression
  Scenario Outline: Login Data Driven
      Given user launch browser
      When user opens url "http://admin-demo.nopcommerce.com/login"
      And user enters email as "<email>" and password as "<password>"
      And click on Login
      Then page title should be "Dashboard / nopCommerce administration"
      When user click on log out link
      Then page title should be "Your store. Login"
      And close browser

      Examples:
        | email               | password      |
        | admin@yourstore.com | admin         |
#        | test@yourstore.com  | incorrectpass | Incorrect email and password
