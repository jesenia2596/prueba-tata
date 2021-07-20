Feature: Login

  Scenario Outline:  Login

    Given user is page home
    When Users click in log in
    And I type information in the modal field UserName <UserName>
    And I type information in the modal field Password <Password>
    Then user view home page <Message>

    Examples:
      |UserName     |Password |Message          |
      |yesenia      |123      |Welcome yesenia  |
