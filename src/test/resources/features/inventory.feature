@inventory
Feature: Inventory Page Validation

  Background:
    Given User is on login page
    When user enters username "standard_user" and password "secret_sauce" and click on login button

  Scenario: Verify user lands on inventory page
    Then user should be on inventory page

  Scenario: Verify inventory title
    Then inventory title should be "Products"

  Scenario: Verify product list
    Then product list should be displayed

  Scenario: Verify product count
    Then product count should be greater than 0

  Scenario: Verify product details visibility
    Then all product names should be visible
    And all product prices should be visible
    And all product images should be visible
    And all add to cart buttons should be visible

  Scenario: Verify product consistency
    Then all product components count should match

  Scenario: Verify expected product count
    Then total product count should be 6