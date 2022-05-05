Feature: User Accounts
  Scenario: Admin user can login to the application

    Given Admin user is in login page
    When Admin user logs in with valid details
    Then Admin user should see the dashboard
    Then User should logout