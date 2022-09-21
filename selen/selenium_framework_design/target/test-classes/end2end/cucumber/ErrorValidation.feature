
Feature: Error validation


    @ErrorValidation
    Scenario Outline: Positive test of Submitting the ordr
        Given I landed on Ecommerce Page
        When Logged in with username <name> and password <password>
        Then "Incorrect email or password." message is displayed


        Examples:
            | name  | password |
            | upoje | 123upoje |