Feature: Login Test CMS

   Background: Navigate to Login page for Admin
      Given User navigate to Login Page for Admin "https://cms.anhtester.com/login"

   @Regression
   Scenario: Login success
      When user enter email "admin@example.com" password "123456"
      And click Login button
      Then user is redirected to the Dashboard page