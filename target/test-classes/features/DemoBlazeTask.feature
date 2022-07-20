@regression
Feature: DemoBlaze task solution

  Background: User is on DemoBlaze main page
    Given User is on the DemoBlaze page

  @Test1
  Scenario Outline: Adding to cart "<Category>" item
    When User navigates to "<Category>" category
    And User selects "<Product>"
    And User clicks Add to cart
    Then User should see Product added pop up notification and confirm it
    Examples:
      | Category | Product |
      | Laptops  | Sony vaio i5 |
      | Phones | Samsung galaxy s6 |
      | Monitors | Apple monitor 24 |

  @Test2
  Scenario: Deleting Monitor item from cart
    When User navigates to Cart menu
    And User deletes "Apple monitor 24" from cart
    And User clicks Place order
    And User fills Place Order form
    And User clicks Purchase
    And User verifies amount is correct
    And User clicks Ok
    Then User should see there is no product in the cart