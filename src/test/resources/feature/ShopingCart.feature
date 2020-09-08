@ShoppingCart
Feature: Shopping cart functionality

  @checkProduct
  Scenario: user can check if a product is added to cart
    Given user navigates to 'http://automationpractice.com/index.php' page
    And user is on the 'Home' page
    When user select a 'Product'
    Then 'Add to cart' button is displayed
    And Add to cart button is to the left of 'More' button
    When user clicks to 'Add to cart' button
    Then 'Cart Info' is displayed
    And user clicks to 'Continue shopping' button
    And user is on the 'Home' page
    Then user selects 'Shopping Cart'
    And the 'Item product' is displayed