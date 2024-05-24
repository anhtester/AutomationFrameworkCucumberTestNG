Feature: Sign in page CRM

   @Regression @device_Window_10 @author_AnVo
   Scenario Outline: Sign in CRM with an email valid
      Given User navigate to url "<url>"
      When User login with username "<username>" and password "<password>" valid
      Then The user redirect to Dashboard page
      Examples:
         | url                               | username          | password |
         | https://rise.anhtester.com/signin | admin@example.com | 123456   |

   @Smoke @device_Window_10 @author_AnVo
   Scenario Outline: Sign in CRM with an email invalid
      Given User navigate to url "<url>"
      When User login with username "<username>" and password "<password>" invalid
      Then The user can not redirect to Dashboard page
      And The error message is displays
      Examples:
         | url                               | username         | password |
         | https://rise.anhtester.com/signin | demo@example.com | 123456   |