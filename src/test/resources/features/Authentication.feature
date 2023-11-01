@e2e @auth
Feature: Test login, logout, and account creation

@one
Scenario: Log in as existing user
    Given I open the application
    When I log in as an existing user
    Then the main brand header should display
    And the page title text should be present

Scenario: Attempt to log in as existing user
    Given I open the application
    When I enter invalid user credentials 
    Then I should be on the login screen
    Then the text "User does not exist." should display

Scenario: Log out of account
    Given I open the application
    And I log in as an existing user
    When I click the sign out button
    Then I should be on the login screen


