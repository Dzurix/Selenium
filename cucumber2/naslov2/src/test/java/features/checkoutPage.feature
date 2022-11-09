Feature: Place the order of Products

    @PlaceOrder
    Scenario Outline: User experience for product search
        Given user is on GreenKart landing page
        When user searched with Shortname <Name> and extracted actual name of product
        And added "3" items of the selected product to cart
        Then user proceeds to Checkout and validate the <Name> items in checkout page
        And verify user has ability to enter promo code and place the order


        Examples:
            | Name |
            | Tom  |


