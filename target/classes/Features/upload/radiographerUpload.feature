###@beSureToLogOut
#Feature: UploadFeature
#  This feature handles the positive and negative upload functionality for all users
#
#  Scenario: Validate that radiographer can not upload invalid study Successfully (Wrong document)
#    Given that user is logged in using below credentials
#      | username | owolebir@gmail.com |
#      | password | 12345678           |
#    When user clicks upload option on the side bar menu
#    And user navigates to the upload tab
#    Then system displays scan upload page
#    When user clicks the upload button
#    Then System displays the upload modal
#    When User uploads file "testdoc.pdf"
#    Then system displays wrong file format error notification
#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully
#
#  Scenario: Validate that radiographer can not upload invalid study Successfully (wrong extension)
#    Given that user is logged in using below credentials
#      | username | owolebir@gmail.com |
#      | password | 12345678           |
#    When user clicks upload option on the side bar menu
#    And user navigates to the upload tab
#    Then system displays scan upload page
#    When user clicks the upload button
#    Then System displays the upload modal
#    And User uploads file "testdoc.pdf"
#    Then system displays wrong file format error notification
#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully
#
#  Scenario: Validate that radiographer can upload valid study Successfully
#    Given that user is logged in using below credentials
#      | username | owolebir@gmail.com |
#      | password | 12345678           |
#    When user clicks upload option on the side bar menu
#    And user navigates to the upload tab
#    Then system displays scan upload page
#    When user clicks the upload button
#    And User uploads file "testdoc.dcm"
#    Then system uploads record successfully
#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully
