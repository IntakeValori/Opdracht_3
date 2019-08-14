Feature: Test navigation on the valori.nl homepage

  Scenario: As a user I can navigate the website to read about the Mobile Chapter
    Given I am on the Valori homepage
    And I navigate to the Mobile Chapter page
    Then I can read articles about the Mobile Chapter


  Scenario Outline: As a user I can navigate to the contact form from the FST page
    Given I am on the Valori homepage
    And I navigate to the Mobile Chapter page
    And I contact Valori
    Then the contact us form is available
    Given fill the contact form with my <Firstname>, <Lastname>, <Companyname>, <Email>, <Phonenumber> and <Message>

    Examples:
      | Firstname  | Lastname  | Companyname  | Email                   | Phonenumber | Message                     |
      |  Aka1313   |  Foederr  | Valori       | akashfoederer@valori.nl | 0639049935  | dit is een automated test   |
      |  Akash!#*  |  Foederer | Valori       | akashfoederer@valori.   | 0639049935  | dit is een automated test   |
      |  Akash313!#|  Foederer | Valori       | akashfoederervalori.nl  | 0639049935  | dit is een automated test   |
      |  Akash     |  Foederer | Valori       | akashfoederer@valori.nl | 0639049935  | dit is een automated test   |
