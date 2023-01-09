@beSureToLogOut
Feature: Radiologist Accept Report
  This feature handles the Radiologist Accept Report

  # Radiologist Accept Report
  @TE0028
  Scenario: Validate the Radiologist Accept Report
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
    Then user clicks the Mark as Read Button
    When System displays reporting queue popup
    Then User Click The Yes Button
    When System Displays Ready Tag In Study Details
    When the user navigates and clicks the profile icon
    And user clicks the logout button
    Then user is logged out successfully
    And User provides valid username and password
      | username | nwokogodsfavour2@gmail.com |
      | password | 12345678                   |
    And User clicks the sign-in button
    Then System displays the business selection page
    When user selects business
    Then System grants user access successfully
    When user clicks work list option on the side bar menu
    Then System displays work list page successfully
    When user clicks the menu option to view a study details
    Then system displays study details page successfully
    Then User clicks the Accept button
    When System displays accept reporting popup
    Then User clicks the OK button

#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully
