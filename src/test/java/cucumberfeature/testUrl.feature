Feature: Test Url

  Scenario: Check url logo
    Given I am at home page
    When I click on logo
    Then i should be on home page

  Scenario: Check url login
    Given I am at home page
    When I click on login
    Then i should be on login page
#
  Scenario: Check url cart
    Given I am at home page
    When I click on cart
    Then I should be on cart page

  Scenario: Check url Headset
    Given I am at home page
    When I click on headset
    Then I should be on headset page

  Scenario: Check url Headset Item
    Given I am at  headset page
    When I click on headset item
    Then I should be on headset item page