Feature: Log in functionality

  Scenario: User can log in
    Given user is on login page
    When user inputs valid username
    And user inputs valid password
    And user clicks on Login button
    Then user is logged in
    And redirected to homepage

  Scenario Outline: User cannot log in with invalid password
    Given user is on login page
    When user inputs valid username
    And user inputs invalid <password> into password field
    And user clicks on Login button
    Then user is not logged in
    And error message appears
    Examples:
      | password       |
      | "password 123" |
      | "123123123"    |
      | "pass 2233!@#" |

  Scenario Outline: User cannot log in with invalid username and password
    Given user is on login page
    When user inputs invalid <username> into username field
    And user inputs invalid <password> into password field
    And user clicks on Login button
    Then user is not logged in
    And error message appears
    Examples:
      | username    | password  |
      | "user1"     | "pass1"   |
      | "blabla123" | "123"     |
      | "no_user"   | "no_user" |

