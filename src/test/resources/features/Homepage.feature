@e2e @homepage
Feature: Test homepage
  User can log in and use basic features of the application

  Background: Launch app and login
    Given I am logged in as an existing user

  Scenario: Navigate between pages using side navigation
    When I navigate to the "SETTINGS" page
    Then the "SETTINGS" page heading should display
    When I navigate to the "ABOUT" page
    Then the "ABOUT" page heading should display
    When I navigate to the "HOME" page
    Then the "HOME" page heading should display

