Feature: As a user
  I should be able to add/delete/edit product form bag


  Background: Bag

    Given I am on home page "https://www.saucedemo.com/"
    When I do Login with username "standard_user" and password "secret_sauce"
    When I choose a product "Sauce Labs Backpack"
    When I click Add to cart button with badge "1"

@regression @bag
  Scenario: Verify add a product to bag


    When I click bag icon
    Then I should see product "Sauce Labs Backpack" in the bag

 @regression @bag
  Scenario: Verify remove product from bag


    When I click bag icon
    When I click remove button in bag
    Then The product "Sauce Labs Backpack" should be removed

  @bag @regression
  Scenario: Verify add more product to bag
    When I click back button
    When I choose a product "Sauce Labs Bike Light"
    When I click Add to cart button with badge "2"
    When I click bag icon
    Then I should see products " Sauce Labs Backpack" and "Sauce Labs Bike Light" in the bag

