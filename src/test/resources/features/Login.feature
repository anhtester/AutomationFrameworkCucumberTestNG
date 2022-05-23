Feature: Login Page

  Scenario Outline: Login page to HRM
    Given user navigate to url "<url>"
    When user enter username "<username>" and password "<password>"
    And click login button
    Then The user redirect to Dashboard page
    Examples:
      | url                                 | username | password |
      | https://hrm.anhtester.com/erp/login | admin01  | 123456   |