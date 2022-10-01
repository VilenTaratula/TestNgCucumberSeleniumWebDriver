Feature: Cart
  Background:
    Given I am at home page

    Scenario: Check adding item from list option
      Given I select item option
      When I click on add item to cart
      Then I have added one item in cart

  Scenario: Check item from cart
    Given I add item to cart
    When I click on cart
    Then I have one item in cart

  Scenario: Check delete item from cart
    Given I add item to cart
    When I click delete item from cart
    Then I have empty cart