Feature: Login test

  Scenario: Check  login
    Given I am at login page
    When I try logged with not existing account
    Then I should be on login page with error massage

  Scenario: Check  login without inputting email
    Given I am at login page
    When I try logged without inputting email
    Then I should be on login page with error massage