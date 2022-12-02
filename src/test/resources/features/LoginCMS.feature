Feature: Login Test CMS

  Background: Navigate to Login page for Admin
    Given User navigate to Login Page for Admin "https://demo.activeitzone.com/ecommerce/login"

  @Regression
  Scenario: Login success
    When User enter email "admin@example.com" password "123456" and click Login button
    Then User is redirected to the Dashboard page