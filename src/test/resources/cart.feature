Feature: Cart functionality

  Background: User is on homepage

    Scenario: User can add item to cart
      Given user is on homepage
      When user clicks on add button
      Then item is added to cart

    Scenario: User can add multiple items to cart
      Given user is on homepage
      When user clicks on add button multiple times
      Then items are added to cart
