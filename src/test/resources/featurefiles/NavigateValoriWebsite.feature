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

  Scenario Outline: As a user I want to write my first name, my last name, my email,
  my message so that Valori can help me further
    Given I am on the Valori homepage
    When I navigate to the Mobile Chapter page
    And I contact Valori
    Then I fill in my info
    
  Examples:
  |firstname|L                 |
  |lastname |M                 |
  |email    |whatever@gmail.com|
  |message  |blabla            |
