Feature: Application Login

    Feature Description
    @RegTest @SmokeTest
    Scenario: Home page defalut login

        Given User is on NetBanking landing page
        When User login into application with username "Jin" and password "1234"
        Then Home page is populated
        And Cards displayed are "true"

    @SmokeTest
    Scenario: Home page defalut login

        Given User is on NetBanking landing page
        When User login into application with username "John" and password "4321"
        Then Home page is populated
        And Cards displayed are "false"

    @SmokeTest
    Scenario: Home page defalut login

        Given User is on NetBanking landing page
        When User sign up with folowing details
            | jenny | abcd | jenny@abcd.com | Australia | 123331 |
        Then Home page is populated
        And Cards displayed are "false"

    @RegTest
    Scenario Outline:  Home page defalut login

        Given User is on NetBanking landing page
        When User login into application with username <Username> and password <Password>
        Then Home page is populated
        And Cards displayed are "true"

        Examples:
            | Username | Password   |
            | User 1   | Password 1 |
            | User 2   | Password 2 |
            | User 3   | Password 3 |