Feature: HRM dashboard page

  Background: User is logged to the HRM system
    Given User logged in with email "admin_example" and password "123456"

  @Regression @device_Window_11 @author_AnhTester
  Scenario Outline: Open menu
    Given User navigate to dashboard
    When User click "<menu>"
    Then The user redirect to this page "<menu>"
    Examples:
      | menu     |
      | Projects |
      | Tasks    |