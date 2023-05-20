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

  Scenario: As a user I want to fill the contact form on the performance testen page
    Given I am on the Valori homepage
    And I navigate to the performance testing page
    And I contact Valori
    And I fill in the form
    Then the contact send button is clickable

  Scenario: As a user I want to fill the contact form with random values
    Given I am on the Valori homepage
    And I navigate to the performance testing page
    And I contact Valori
    And I get random persona from random Api
    And I fill in the form
    Then the contact send button is clickable