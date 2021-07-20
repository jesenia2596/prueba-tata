Feature: Sing up

  Scenario Outline:  Sing up succesful

    Given user is in the main page
    When user wants to sign Up
    And types information in the field UserName <UserName>
    And types information in the field  Password <Password>
    Then user should be <Message> in the browser

    Examples:
      |UserName       | Password | Message |
      |prueba2002        |123    | Sign up successful.|



