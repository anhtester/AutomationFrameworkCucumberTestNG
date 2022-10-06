Feature: HRM dashboard page

  Background: User is logged to the HRM system
    Given User logged in with email "frances.burns" and password "frances.burns"

  @Regression
  Scenario Outline: Open menu
    Given User navigate to dashboard
    When User click "<menu>"
    Then The user redirect to this page "<menu>"
    Examples:
      | menu     |
      | Projects |
      | Tasks    |