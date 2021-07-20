Feature: Contact

  Scenario Outline:  Contact

    Given user is page home Contact
    When Users click in Contact
    And I type information in the modal field Contact Email <ContactEmail>
    And I type information in the modal field Contact Name <ContactName>
    And I type information in the modal field Message <Message>
    Then Message is sent and display <Response>


    Examples:
      |ContactEmail      |ContactName |Message| Response |
      |yesenia@gmail.com |Yesenia     | Envio de mensaje| Thanks for the message!! |
