Feature: Form Data User Information

    @valid
  Scenario: User success submit data user
    Given user is on page user information
    And user fill form with valid data
    When user click submit
    Then the form has successfully submitted

    @invalid
  Scenario: User not fill mandatory field in form data user
    Given user is on page user information
    And user fill form with invalid data
    When user click submit
    Then the error message will has displayed
