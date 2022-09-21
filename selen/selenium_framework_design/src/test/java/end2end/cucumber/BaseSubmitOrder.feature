Feature: Purchase the order from Ecommerce site

    Background: Preduslovi

        Given I landed on Ecommerce Page

    @Regression
    Scenario Outline: Positive test of Submitting the ordr
        Given Logged in with username <name> and password <password>
        When I add product <productName> to Cart
        And Checkout <productName> and submit the order
        Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage


        Examples:

            | name                  | password    | productName |
            | rahulshetty@gmail.com | IamKing@000 | ZARA COAT 3 |