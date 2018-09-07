Feature: Test navigation on the valori.nl homepage

  Scenario: As a user I can navigate from the FST page to the career page
    Given I am on the Valori homepage
    And I navigate to the Full Stack page
    Then I want to come and dance


  Scenario: As a user I can navigate to the contact form from the FST page
    Given I am on the Valori homepage
    And I navigate to the Full Stack page
    And I contact Valori
    Then the contact us form is available