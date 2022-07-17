Feature: HRM dashboard page

  Background: User is logged to the HRM system
    Given User logged in with email "admin01" and password "123456"

  Scenario Outline: Open menu
    Given User navigate to dashboard
    When User click "<menu>"
    Then The user redirect to this page
    Examples:
      | menu  |
      | Dự án |
      | Task  |