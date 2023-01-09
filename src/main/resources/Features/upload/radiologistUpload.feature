@beSureToLogOut
Feature: UploadFeature
  This feature handles the positive and negative upload functionality for radiologist

  # File upload (Single and Bulk) (Single File upload)
  @TE0015 @All
  Scenario: T0015 Validate that radiologist can not upload invalid study Successfully (Wrong document)
    Given that user is logged in using below credentials
      | username | nwokogodsfavour2@gmail.com |
      | password | 12345678                   |
    When user clicks upload option on the side bar menu
    And user navigates to the upload tab
    Then system displays scan upload page
    When user clicks the upload button
    Then System displays the upload modal
    When User uploads file "invalidFile.html"
    Then system displays wrong file format error notification
   # And user then logged out successfully
#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully


  # File upload (Single and Bulk) (Single File upload)
  @TE0016 @All
  Scenario: T0016 Validate that radiologist can not upload invalid study Successfully (wrong extension)
    Given that user is logged in using below credentials
      | username | nwokogodsfavour2@gmail.com |
      | password | 12345678                   |
    When user clicks upload option on the side bar menu
    And user navigates to the upload tab
    Then system displays scan upload page
    When user clicks the upload button
    Then System displays the upload modal
    And User uploads file "invalidFile.html"
    Then system displays wrong file format error notification
   # And user then logged out successfully
#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully


# File upload (Single and Bulk) (Single File upload)
  @TE0017 @All
  Scenario: T0017 Validate that radiologist can upload valid study Successfully
    Given that user is logged in using below credentials
      | username | nwokogodsfavour2@gmail.com |
      | password | 12345678                   |
    When user clicks upload option on the side bar menu
    And user navigates to the upload tab
    Then system displays scan upload page
    When user clicks the upload button
    And User uploads file "testdoc.dcm"
    #Then system uploads record successfully
    #And user then logged out successfully
    Then system uploads record successfully

#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully