Feature: Reporting
  This feature handles Admin Review Study

  # Admin can review study
  @TE0027
  Scenario: Validate The Admin Can Review Study
    Given user is on Xcel Website
    Then System displays Login page successfully
    And User provides valid username and password
      | username | benogunmefun@gmail.com|
      | password | 12345678           |
    And User clicks the sign-in button
    Then System displays the business selection page
    When user selects business
    Then System grants user access successfully
    When user clicks work list option on the side bar menu
    Then System displays work list page successfully
    When user clicks the menu option to view a study details
    Then system displays study details page successfully

    When the user navigates and clicks the profile icon
    And user clicks the logout button
    Then user is logged out successfully

