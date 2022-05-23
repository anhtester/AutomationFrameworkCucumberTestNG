Feature: Dashboard page

  Scenario Outline: Open menu
    Given user navigate to dashboard
    When user click "<menu>"
    Then The user redirect to this page
    Examples:
      | menu  |
      | Dự án |
      | Task  |