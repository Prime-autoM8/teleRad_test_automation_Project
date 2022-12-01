##@beSureToLogOut
#Feature: GeneralLoginFeature
#  This feature handles on-boarding functionality for users
#
#  Scenario: Validate that admin can onboard radiologist successfully
#    Given that user is logged in using below credentials
#      | username | benogunmefun@gmail.com |
#      | password | 12345678               |
#    When user clicks users option on the side bar menu
#    And user clicks the add user button
#    Then System displays the add user modal
#    When User provides site and role details as specified below
#      | Center      | Site 2      |
#      | Designation | Radiologist |
#      | email       | random      |
#    And user clicks the Next button to complete on-boarding
#    Then System displays user on-boarding form
#    When user provides relevant details as specified below
#      | firstName         | tester         |
#      | lastName          | tester         |
#      | userName          | tester         |
#      | title             | Mr             |
#      | dateOfBirth       | 10/10/1988     |
#      | gender            | Male           |
#      | phoneNumber       | +2348062805994 |
#      | address           | 6, Keke Str    |
#      | city              | Bariga         |
#      | state             | Lagos          |
#      | country           | Nigeria        |
#      | signatureFileName | Sign.png  |
#    And user clicks the save changes button
#    Then System saves user information successfully
#
#
##  Scenario: Validate that admin can onboard radiographer successfully
##    Given that user is logged in using below credentials
##      | username | benogunmefun@gmail.com |
##      | password | 12345678               |
##    When user clicks users option on the side bar menu
##    And user clicks the add user button
##    Then System displays the add user modal
##    When User provides site and role details as specified below
##      | Center        | Default Site           |
##      | Designation : | Radiographer           |
##      | email         | benogunmefun@gmail.com |
##    And user clicks the Next button to complete on-boarding
##    Then System displays user on-boarding page 2
##    When user provides relevant details as specified below
##      | firstName         |  |
##      | lastName          |  |
##      | userName          |  |
##      | title             |  |
##      | dateOfBirth       |  |
##      | gender            |  |
##      | phoneNumber       |  |
##      | address           |  |
##      | city              |  |
##      | state             |  |
##      | country           |  |
##      | signatureFileName |  |
##    And user clicks the save changes button
##    Then System saves user information successfully
