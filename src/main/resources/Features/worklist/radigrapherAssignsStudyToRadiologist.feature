@beSureToLogOut
Feature: Radigrapher Assigns Study to Radiologist/doctor

This feature handles Radigrapher Assigns Study to Radiologist/doctor

  # Radigrapher assigns study to radiologist/doctor (BUG)
  @TE0023
  Scenario: Validate that Radigrapher Assigns Study to Radiologist/doctor
    Given user is on Xcel Website
    Then System displays Login page successfully
    Given that user is logged in using below credentials
      | username | owolebir@gmail.com |
      | password | 12345678           |
    When user clicks work list option on the side bar menu
    Then System displays work list page successfully
    When Radigrapher assigns study to "One Radiologist", where radiographer is yet to be assigned for last study uploaded

#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully
