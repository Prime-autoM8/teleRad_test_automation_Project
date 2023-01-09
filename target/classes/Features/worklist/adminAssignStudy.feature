@beSureToLogOut
Feature: Admin Assign Study
  This feature handles the positive and negative login functionality for all users

  # Admin assign study
  @TE0018
  Scenario: Validate that admin can assign radiographer to study Successfully
    Given that user is logged in using below credentials
      | username | benogunmefun@gmail.com |
      | password | 12345678               |
    When user clicks work list option on the side bar menu
    Then System displays work list page successfully
    When User assigns study to "One Radiologist", where radiographer is yet to be assigned for last study uploaded

    When the user navigates and clicks the profile icon
    And user clicks the logout button
    Then user is logged out successfully

