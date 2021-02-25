Feature: Test navigation on the valori.nl homepage

  Scenario: As a user I can navigate the website to read about the Mobile Chapter
    Given I am on the Valori homepage
    And I navigate to the Mobile Chapter page
    Then I can read articles about the Mobile Chapter


  Scenario: As a user I can navigate to the contact form from the FST page
    Given I am on the Valori homepage
    And I navigate to the Mobile Chapter page
    And I contact Valori
    Then the contact us form is available

  Scenario Outline: As a user I fill in the contact form
    Given I am on the Valori homepage
    And I contact Valori
    And the contact us form is available
    And I fill it in with legal values for "firstName", "lastName", "email", "message"
    Then I can send the contact form
    Examples:
      | firstName    | lastName    | email    | message    |
      | "firstname1" | "lastname1" | "email1" | "message1" |
      | "firstname2" | "lastname2" | "email2" | "message2" |