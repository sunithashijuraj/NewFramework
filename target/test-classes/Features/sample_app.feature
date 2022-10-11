#Author: sunitha
## (Comments)
#Sample Feature Definition Template
Feature: Validate Sample App

  Scenario: Create a test that Logins Sample App using any non-empty user name and `pwd` as password
    Given User is on UI Test Automation Playground Page
    When user click on Sampe App link
    And user landed on Sample App page
    When user enters Username and Password
    And Click on Login Button
    Then user Welcome message displays