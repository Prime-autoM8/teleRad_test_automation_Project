@beSureToLogOut
Feature: Radiologist makes report Dictated
  This feature handles the Radiologist makes report Dictated

  # Radiologist / admin makes report dictated (BUG)
  @TE0031
  Scenario: Validate the Radiologist makes report Dictated
    Given user is on Xcel Website
    Then System displays Login page successfully
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
    Then User clicks the Go To Report
    When System Displays Report Write Page

#    When User write the report as specified below
#    |     Technique     |    test text     |
#    |     Comparison    |    test text     |
#    |     Findings      |    test text     |
#    |     Impressions   |    test text     |

    Then User clicks the Save Report button
    When System displays save report popup

    Then User clicks the Dictated radio button

    When User Clicks the save button
    Then System displays Report saved popup

#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully
