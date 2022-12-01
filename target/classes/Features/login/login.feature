#@beSureToLogOut
Feature: GeneralLoginFeature
  This feature handles the positive and negative login functionality for all users

  Scenario: Validate that user can not login Successfully with invalid credentials (wrong username, wrong password)
    Given user is on Xcel Website
    Then System displays Login page successfully
    And User provides invalid username and password
      | username | wrongemail@parallelscore.com |
      | password | wrongpass                    |
    And User clicks the sign-in button
    Then System displays error notification

  Scenario: Validate that user can not login Successfully with invalid credentials (correct username, wrong password)
    Given user is on Xcel Website
    Then System displays Login page successfully
    And User provides invalid username and password
      | username | benogunmefun@gmail.com |
      | password | wrongpass              |
    And User clicks the sign-in button
    Then System displays error notification

  Scenario: Validate that user can login as admin Successfully
    Given user is on Xcel Website
    Then System displays Login page successfully
    And User provides valid username and password
      | username | benogunmefun@gmail.com |
      | password | 12345678               |
    And User clicks the sign-in button
    Then System displays the business selection page
    When user selects business
    Then System grants user access successfully
    When the user navigates and clicks the profile icon
    And user clicks the logout button
    Then user is logged out successfully

  Scenario: Validate that user can login as Radiologist Successfully
    Given user is on Xcel Website
    Then System displays Login page successfully
    And User provides valid username and password
      | username | nwokogodsfavour2@gmail.com |
      | password | 12345678                   |
    And User clicks the sign-in button
    Then System displays the business selection page
    When user selects business
    Then System grants user access successfully
    When the user navigates and clicks the profile icon
    And user clicks the logout button
    Then user is logged out successfully

  Scenario: Validate that user can login as Radiographer Successfully
    Given user is on Xcel Website
    Then System displays Login page successfully
    And User provides valid username and password
      | username | owolebir@gmail.com |
      | password | 12345678           |
    And User clicks the sign-in button
    Then System displays the business selection page
    When user selects business
    Then System grants user access successfully
    When the user navigates and clicks the profile icon
    And user clicks the logout button
    Then user is logged out successfully
