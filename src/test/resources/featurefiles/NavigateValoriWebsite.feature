Feature: Test navigation on the valori.nl website

Background:
  Given I am on the Valori homepage

  Scenario: As a user I can navigate the website to read about mobile app testing
    When I navigate to the 'Mobile app testing' page
    Then I can read articles about mobile app testing

  Scenario: As a user I can navigate to the contact form from the Test automation page
    When I navigate to the 'Test automation' page
      And I contact Valori
    Then the contact us form is available

  Scenario Outline: As a user I can navigate through the valori website and fill in the contact form
    When I navigate to the '<page>' page
      And I contact Valori
    Then I can fill the 'Voornaam' input field in the contact form with '<first_name>'
      And I can fill the 'Achternaam' input field in the contact form with '<last_name>'
      And I can fill the 'Bedrijfsnaam' input field in the contact form with '<company_name>'
      And I can fill the 'Telefoonnummer' input field in the contact form with '<mobile_number>'
      And I can fill the 'E-mail' input field in the contact form with '<email>'
      And I can fill the 'Jouw bericht' input field in the contact form with '<message>'
    Examples:
      | page            | first_name | last_name | company_name | mobile_number | email        | message           |
      | Test automation | Ernest     | Janssen   |              |               | test@test.nl | Test test test... |
      | Test automation | Ernest     | Janssen   | Test BV      | 06-112        | test@test.nl | message           |