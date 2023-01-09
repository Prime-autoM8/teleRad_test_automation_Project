@beSureToLogOut
Feature: Assign CPT to study
  This feature handles assignment of CPT to study

  # Admin, Radiologist Assign CPT Code (BUG)
  @TE0019 @All
  Scenario: T0019 Validate that radiologist can assign CPT to study

    Given user is on Xcel Website
    Then System displays Login page successfully
    And User provides valid username and password
      | username | owolebir@gmail.com |
      | password | 12345678           |
    And User clicks the sign-in button
    Then System displays the business selection page
    When user selects business
    Then System grants user access successfully
    When user clicks work list option on the side bar menu
    Then System displays work list page successfully
    When user clicks the menu option to view a study details
    Then system displays study details page successfully
    When user clicks the edit buton
    And user provides update details as specified below
      | fullname     | Test User                 |
      | dateOfBirth  | 01/01/1980                |
      | technique    | abass remi                |
      | refPhysician | 12345ty                   |
      | sex          | Male                      |
      | technician   | Samuel                    |
      | description  | This is an updated record |
      | priority     |                           |
      | assignTo     |                           |
      | modality     | PT                        |
    And user clicks the save button
    Then System displays the success pop up successfully
    Given user is on the study view page

    When user clicks the add new button to assign CPT Code
    Then system displays CPT code PopUp
    When user clicks the add CPT Codes button
    And adds cpt code
    Then user clicks the save button

    When the user navigates and clicks the profile icon
    And user clicks the logout button
    Then user is logged out successfully
