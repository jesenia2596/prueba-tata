Feature: Car

  Scenario Outline: Add products to shopping cart

    Given I am entry in the application with user <UserName> and password <Password>
    When  Users click in categories Laptops
    And   Users click in macbook Pro
    And   Users click in add to cart
    And   user view <Message> Product added
    Then  user can see the added product in the shopping cart


    Examples:
      |UserName     | Password |Message|
      |yesenia      |123   |Product added.|
