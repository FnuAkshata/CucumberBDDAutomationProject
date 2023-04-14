Feature:Account Page

  Background:
    Given User has already logged in to application
        |username      | password     |
        |Saha@emil.com | Saha@123   |

    Scenario: Accounts page title
      Given user is on Account page
      When user gets the title of the page
      Then page title should be "My account - My Store"

      Scenario: Accounts section count
        Given user is on Account page
        Then user gets accounts section
        |ADD MY FIRST ADDRESS|
        |ORDER HISTORY AND DETAILS|
        |MY CREDIT SLIPS|
        |MY ADDRESSES|
        |MY PERSONAL INFORMATION|
        |Home|
        And Account section count should be 6

