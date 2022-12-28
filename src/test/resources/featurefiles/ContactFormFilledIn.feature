Feature: Test that the contact form can be filled in

  Background: Filling the contact form on the contact us page
    Given I am on the Valori homepage
    And I navigate to the Mobile Chapter page
    And I contact Valori
    And the contact us form is available

  Scenario Outline: Fill in mandatory fields on the contact form page
    Then I fill in all the mandatory fields, "<firstName>" , "<lastName>", "<email>"

    Examples:
      | firstName | lastName |    email                   |
      |    John   |   Doe    |    valoritesters@gmail.com |

  Scenario Outline: Fill in all the fields on the contact form page
    And I fill in all the mandatory fields, "<firstName>" , "<lastName>", "<email>"
    Then I fill in all the remaining fields, "<companyName>", "<phoneNumber>", "<messageField>"

    Examples:
      | firstName | lastName |    email                   | companyName | phoneNumber    | messageField   |
      |    Jane   |   Doe    |    valoritesters@gmail.com | GV          |  02313131      | this is a test |