Feature: Smoke
  As a user
  I want to test all main site functional
  So that I can be sure that site works correctly

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks main logo visibility
    And User checks women button visibility
    And User checks men button visibility
    And User checks search input visibility
    And User checks sign in button visibility
    When User clicks sign in button
    And User checks sign in button visibility in popup
    And User checks join button visibility in popup
    And User closes sign in popup
    And User checks wish button visibility
    And User checks cart visibility
    And User checks country button visibility
    When User clicks country button
    And User checks that country popup visible
    Then User checks country popup header is '<header>'

    Examples:
      | homePage              |header                 |
      | https://www.asos.com/ |PREFERENCES            |

  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User checks search input visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks wish list on first product
    When User clicks wish button
    Then User checks that amount of products in wish list are '<amountOfProducts>'

    Examples:
      | homePage              | keyword       | amountOfProducts |
      | https://www.asos.com/ | sunglasses    | 1 item           |

  Scenario Outline: Check that count of products in wishlist is correct
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks wish list on first product
    And User clicks wish list on second product
    When User clicks wish button
    Then User counts amount of products in wish list and checks if it equals '<amountOfProducts>'

    Examples:
      | homePage              | keyword       | amountOfProducts |
      | https://www.asos.com/ | sunglasses    | 2 items          |

  Scenario Outline: Check remove product from wishlist
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks wish list on first product
    And User clicks wish list on second product
    When User clicks wish button
    Then User checks that amount of products in wish list are '<amountOfProducts>'
    And User removes one product from wish list
    Then User checks that amount of products in wish list are '<amountOfProductsAfter>'

    Examples:
      | homePage              | keyword       | amountOfProducts | amountOfProductsAfter |
      | https://www.asos.com/ | sunglasses    | 2 items          | 1 item                |

  Scenario Outline: Check move product from wishlist to cart
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks wish list on first product
    When User clicks wish button
    And User moves one product from wish list to cart
    Then User checks that amount of products in cart are '<amountOfProducts>'
    And User checks that wishlist is '<empty>'

    Examples:
      | homePage              | keyword       | amountOfProducts | empty                  |
      | https://www.asos.com/ | sunglasses    | 1 item           | You have no Saved Items|

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks Add to Cart button on product
    And User checks that add to cart popup visible
    Then User checks that in cart is '<amountOfProducts>'

    Examples:
      | homePage                            | keyword  | amountOfProducts |
      | https://www.asos.com/               | 1590649  | 1 item           |

  Scenario Outline: Check remove product from cart
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks Add to Cart button on product
    And User checks that add to cart popup visible
    Then User checks that in cart is '<amountOfProducts>'
    When User clicks View Cart Button
    And User clicks Remove Button
    Then User checks that cart is '<empty>'

    Examples:
      | homePage                            | keyword  | amountOfProducts | empty             |
      | https://www.asos.com/               | 1590649  | 1 item           | Your bag is empty |

  Scenario Outline: Check registration
    Given User opens '<homePage>' page
    When User clicks sign in button
    And User checks join button visibility in popup
    When User clicks join popup button
    And User checks Email address for registration input is visible
    And User checks Password input is visible
    And User checks First Name input is visible
    And User checks Last Name input is visible
    And User checks Birth Day input is visible
    And User checks Birth Month input is visible
    And User checks Birth Year input is visible
    And User fill in Email address for registration input with '<email>'
    And User fill in Password input with '<password>'
    And User fill in First Name input with '<firstName>'
    And User fill in Last Name input with '<lastName>'
    And User fill in Birth Day input with '<birthDay>'
    And User fill in Birth Month input with '<birthMonth>'
    And User fill in Birth Year input with '<birthYear>'
    When User clicks Join button

    Examples:
      | homePage              |email                      | password   | message | firstName | lastName  | birthDay | birthMonth | birthYear |
      | https://www.asos.com/ |renata.sotnykova@gmail.com | qwerty1234 |         | Renata    | Sotnykova | 1        | March      | 1990      |

  Scenario Outline: Check sign in with wrong password
    Given User opens '<homePage>' page
    When User clicks sign in button
    And User checks sign in button visibility in popup
    When User clicks sign in popup button
    And User checks Email address input is visible
    And User checks Password input is visible
    And User fill in Email address input with '<email>'
    And User fill in Password input with '<wrongPassword>'
    When User clicks Sign in button
    Then User checks '<errorMessage>' is shown

    Examples:
      | homePage              |email                | wrongPassword | errorMessage                             |
      | https://www.asos.com/ |sotnikoffa@gmail.com | qwerty        | email address or password were incorrect |

  Scenario Outline: Check sign in with correct password
    Given User opens '<homePage>' page
    When User clicks sign in button
    And User checks sign in button visibility in popup
    When User clicks sign in popup button
    And User checks Email address input is visible
    And User checks Password input is visible
    And User fill in Email address input with '<email>'
    And User fill in Password input with '<correctPassword>'
    When User clicks Sign in button
    And User clicks sign in button
    Then User checks sign in was successful and '<message>' is shown

    Examples:
      | homePage              |email                | correctPassword | message     |
      | https://www.asos.com/ |sotnikoffa@gmail.com | qwerty1234      | Hi Kate     |



