Feature: Application Login

    Feature Description
    @SmokeTest
    Scenario: Home page defalut login

        Given User is on NetBanking landing page
        When User login into application with username "Jin" and password "1234"
        Then Home page is populated
        And Cards displayed are "true"

