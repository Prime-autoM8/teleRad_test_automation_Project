@beSureToLogOut
Feature: Reporting
  This feature handles study is ready for reporting

  @TE0024
  Scenario: Validate the Study is ready for Reporting
    Given user is on Xcel Website
    Then System displays Login page successfully
    And User provides valid username and password
      | username | benogunmefun@gmail.com |
      | password | 12345678               |
    And User clicks the sign-in button
    Then System displays the business selection page
    When user selects business
    Then System grants user access successfully
    When user clicks work list option on the side bar menu
    Then System displays work list page successfully
    When user clicks the menu option to view a study details
    Then system displays study details page successfully
    And user clicks the Mark as Read Button
    Then System displays reporting queue popup

    Then User Click The Yes Button
    When System Displays Ready Tag In Study Details
