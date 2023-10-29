Feature: Test homepage
  User can log in and use basic features of the application

  Scenario: Log in as an existing User
    When I load the application
    And I log in as an existing user
    Then the main brand header should be visible

  Scenario: Navigate between pages using side navigation
    When I load the application
    And I log in as an existing user
    Then the "HOME" page heading should display
    When I navigate to the "SETTINGS" page
    Then the "SETTINGS" page heading should display
    When I navigate to the "ABOUT" page
    Then the "ABOUT" page heading should display
