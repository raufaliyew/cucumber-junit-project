Feature: DemoBlaze task solution

  Background: User is on DemoBlaze main page
    Given User is on the DemoBlaze page

  @Test1
  Scenario: Adding to cart Laptop item
    When User navigates to "Laptops" category
    And User selects "Sony vaio i5"
    And User clicks Add to cart
    Then User should see Product added pop up notification and confirm it

  @Test2
  Scenario: Adding to cart Phones item
    When User navigates to "Phones" category
    And User selects "Samsung galaxy s6"
    And User clicks Add to cart
    Then User should see Product added pop up notification and confirm it

  @Test3
  Scenario: Adding to cart Monitors item
    When User navigates to "Monitors" category
    And User selects "Apple monitor 24"
    And User clicks Add to cart
    Then User should see Product added pop up notification and confirm it

  @Test4
  Scenario: Deleting Monitor item from cart
    When User navigates to Cart menu
    And User deletes "Apple monitor 24" from cart
    And User clicks Place order
    And User fills Place Order form
    And User clicks Purchase
    And User verifies amount is correct
    And User clicks Ok
    Then User should see there is no product in the cart






#  • Customer navigation through product categories: Phones, Laptops and Monitors
#  • Navigate to "Laptops" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
#  • Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
#  • Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.
#  • Navigate to "Cart" → Delete "Apple monitor 24" from cart.
#  • Click on "Place order".
#  • Fill in all web form fields.
#  • Click on "Purchase"
#  • Capture and log purchase Id and Amount.
#  • Assert purchase amount equals expected.
#  • Click on "Ok"
#  • Verify that there is no product in the cart
