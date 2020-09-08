@ProceedToCheckout
Feature: Add to cart functionality

  @checkAddToCart
  Scenario: user can add a product to cart
    Given user navigates to 'http://automationpractice.com/index.php' page
    And user is on the 'Home' page
    When user selects a 'Product'
    Then user is on the 'Product' page
    Then 'Add to cart' button is displayed
    And 'Add to cart' button is on the right of the product
    When user clicks to 'Add to cart' button
    Then 'Cart Info' is displayed
    When user clicks to 'Proceed to checkout' button
    Then user is on the 'Checkout' page
    And user is on the 'Summary' step
    And product 'Printed Dress' is 'In stock'
    When user clicks to 'Proceed to checkout' button
    Then user is on the 'Sign In' step
    And user types a registered email into 'Email' field
    And user types a registered password into 'Password' field
    When user clicks to 'Submit' button
    Then user is on the 'Address' step
    When user clicks to 'Process Address' button for proceed to checkout
    Then user is on the 'Shipping' step
    And 'Delivery option' is displayed
    When user clicks to 'Process Carrier' button for proceed to checkout
    Then a pop-up 'message' is displayed
    When user clicks to 'Close' button
    And user agrees to the 'Terms of service'
    And user clicks to 'Process Carrier' button for proceed to checkout
    Then user is on the 'Payment' step
    And product 'Printed Dress' is 'In stock'


