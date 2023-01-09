Feature: Reporting
  This feature handles Radiologist read report

  # Radiologist can read report
  @TE0025
  Scenario: Validate the Radiologist read report
    Given user is on Xcel Website
    Then System displays Login page successfully
    And User provides valid username and password
      | username | nwokogodsfavour2@gmail.com |
      | password | 12345678           |
    And User clicks the sign-in button
    Then System displays the business selection page
    When user selects business
    Then System grants user access successfully
    When user clicks work list option on the side bar menu
    Then System displays work list page successfully
    When user clicks the menu option to view a study details
    Then system displays study details page successfully

    Then User Click Accept Button
    When System Displays Popup Like Are You Sure Accept Study For Reporting
    Then User Click Yes Button

#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully


