Feature: Changing language

  Scenario: Change to German
    Given I am at main page
    When I change to German
    Then I expect German on page

  Scenario: Change to German
    Given I am at main page
    When I change languages
    Then I expect ganged languages on page
