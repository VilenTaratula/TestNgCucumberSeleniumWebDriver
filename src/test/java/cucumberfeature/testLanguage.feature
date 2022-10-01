Feature: Changing language

  Scenario: Change to German
    Given I am at main page
    When I change to German
    Then I expect German on page

  Scenario: Try change all languages
    Given I am at main page
    When I change languages
    Then I expect changed languages on page
