Feature: Search and place the order of Products

    Scenario: User experience for product search
        Given user is on GreenKart landing page
        When user searched with Shortname "Tom" and extracted actual name of product
        Then user searched for "Tom" Shortname in offers page
        And validate product name in offers page matches with product name on landing Page

