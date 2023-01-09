@beSureToLogOut
Feature: UploadFeature
  This feature handles the positive and negative upload functionality for admin

  # File upload (Single and Bulk) (Single File upload)
  @TE008 @Regression
  Scenario: Validate that admin can not upload invalid study Successfully (Wrong document)
    Given that user is logged in using below credentials
      | username | benogunmefun@gmail.com |
      | password | 12345678               |
    When user clicks upload option on the side bar menu
    And user navigates to the upload tab
    Then system displays scan upload page
    When user clicks the upload button
    Then System displays the upload modal
    When User uploads file "invalidFile.html"
    Then system displays wrong file format error notification

#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully


    # File upload (Single and Bulk) (Single File upload) (BUG)
    @TE009 @Regression
  Scenario: Validate that admin can not upload invalid study Successfully (wrong extension)
    Given that user is logged in using below credentials
      | username | benogunmefun@gmail.com |
      | password | 12345678               |
    When user clicks upload option on the side bar menu
    And user navigates to the upload tab
    Then system displays scan upload page
    When user clicks the upload button
    Then System displays the upload modal
    And User uploads file "testdoc.pdf"
    Then system displays wrong file format error notification

#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully


      # File upload  (Single and Bulk) (Single File upload)
      @TE0010 @Regression
  Scenario: Validate that admin can upload valid study Successfully
    Given that user is logged in using below credentials
      | username | benogunmefun@gmail.com |
      | password | 12345678               |
    When user clicks upload option on the side bar menu
    And user navigates to the upload tab
    Then system displays scan upload page
    When user clicks the upload button
    And User uploads file "testdoc.dcm"
    Then system uploads record successfully

#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully

        # File upload (Single and Bulk) (Bulk upload)
  @TE0011 @Regression
  Scenario: Validate that admin can upload valid study Successfully
    Given that user is logged in using below credentials
      | username | benogunmefun@gmail.com |
      | password | 12345678               |
    When user clicks upload option on the side bar menu
    Then system displays zip upload page
    And user navigates to the zip upload tab
    When user clicks the upload button
    And User uploads zip file "MicroDicom.zip"
    Then system uploads zip file successfully

#    When the user navigates and clicks the profile icon
#    And user clicks the logout button
#    Then user is logged out successfully

