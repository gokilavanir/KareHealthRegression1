Feature: Delivery Boys module test

  Scenario Outline: Admin can create delivery boys

    Given Admin user is in login page
    When Admin user logs in with valid details
    And Admin is in create delivery boys page
    When Admin enters valid data in fields "<Delivery boy name>","<Phone number>","<Email>","<Password>"
    And Submit to create delivery boys
    Then New delivery boys should be created
    Then User should logout

    Examples:
      |   Delivery boy name | Phone number       |   Email                  | Password   |
      |   Test delivery     | 98789456741        |   test10@gmail.com       | test123    |

  Scenario Outline: Admin cannot create delivery boys with invalid phone number

    Given Admin user logs in with valid details
    And Admin is in create delivery boys page
    When Admin enters invalid phone number in fields "<Delivery boy name>","<Phone number>","<Email>","<Password>"
    And Submit to create delivery boys
    Then User should be asked to enter valid phone number
    Then User should logout

    Examples:
      |   Delivery boy name | Phone number       |   Email                  | Password   |
      |   Test delivery     | 98789456        |   test10@gmail.com       | test123    |