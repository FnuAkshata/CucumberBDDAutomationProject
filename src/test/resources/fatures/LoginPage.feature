Feature:login page

  Background:
    Given User is on the automationpractice login page



    Scenario: Login page title
      Given User is on the automationpractice login page
      When user gets the title of the page
      Then page title should be "Login - My Store"


  Scenario: Successful login with valid credentials
    Given I have entered the valid username and password
    When I click on the login button
    Then I should be logged in successfully


  Scenario: Navigating to the forgotten password page
    When I click on the "Forgot Password" link
    Then I should be redirected to the password reset page