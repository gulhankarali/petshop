Feature: Login feature
  As a user, I should be able to login in with Etsy Account as well as Google and Facebook accounts
  Scenario: Login with right credentials (positive)
    Given User clicks on Get Started
    When Login with Etsy credentials
    Then User verifies that etsy logo is displayed

