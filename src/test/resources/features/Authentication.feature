@e2e @login
Feature: Test login, logout, and account creation

Scenario: Log in as existing user
    When I open the application
    And I log in as an existing user
    Then the main brand header should display
    And the page title text should be present

Scenario: Log out of account
    Given I open the application
    And I log in as an existing user
    When I click the sign out button
    Then I should be on the login screen

