##@beSureToLogOut
#Feature: View Study
#This feature handles the view study on worklist table
#  Scenario: Validate that radiologist can not view study successfully
#    Given user is on Xcel Website
#    Then System displays Login page successfully
#    And User provides valid username and password
#      | username | owolebir@gmail.com |
#      | password | 12345678           |
#    And User clicks the sign-in button
#    Then System displays the business selection page
#    When user selects business
#    Then System grants user access successfully
#    When user clicks work list option on the side bar menu
#    Then System displays work list page successfully
#    When user clicks the menu option to view a study details
#    Then system displays study details page successfully
#    When user clicks the edit buton
#    And user provides update details as specified below
#      | fullname     | Test User                 |
#      | dateOfBirth  | 01/10/1980                |
#      | technique    | abass remi                |
#      | refPhysician | 12345ty                   |
#      | sex          | Male                      |
#      | technician   | Samuel                    |
#      | description  | This is an updated record |
#      | priority     |                           |
#      | assignTo     |                           |
#      | modality     | PT                        |
#    And user clicks the save button
#    Then System displays the success pop up successfully
