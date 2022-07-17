Feature: Login page CRM

  @Regression
  Scenario Outline: Login with an email valid
    Given user navigate to url "<url>"
    When user enter username "<username>" and password "<password>"
    And click login button
    Then The user redirect to Dashboard page
    Examples:
      | url                       | username             | password |
      | https://crm.anhtester.com | admin@mailinator.com | 123456   |