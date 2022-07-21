Feature: Sign in page CRM

  @Regression
  Scenario Outline: Sign in CRM with an email valid
    Given User navigate to url "<url>"
    When User login with username "<username>" and password "<password>" valid
    Then The user redirect to Dashboard page
    Examples:
      | url                       | username             | password |
      | https://crm.anhtester.com | admin@mailinator.com | 123456   |

  @Smoke
  Scenario Outline: Sign in CRM with an email invalid
    Given User navigate to url "<url>"
    When User login with username "<username>" and password "<password>" invalid
    Then The user can not redirect to Dashboard page
    And The error message is displays
    Examples:
      | url                       | username                | password |
      | https://crm.anhtester.com | admin123@mailinator.com | 123456   |