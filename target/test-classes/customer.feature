Feature: Customers module test

  Scenario Outline: Admin can create customers and check records

    Given Admin user is in login page
    When Admin user logs in with valid details
  And Admin is in create customer page
  When Admin enters valid data in fields "<Customer name>","<Phone number>","<Email>","<Password>","<Blood Group>"
  And Submit to create customer
  Then New customer should be created
  Then User should logout

  Examples:
    |   Customer name | Phone number       |   Email                  | Password        |Blood Group      |
    |   Test          | 9878945674         |   test11@gmail.com       | test123         |A+               |

  Scenario: Admin cannot create customers with invalid data


