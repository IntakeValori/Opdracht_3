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


  Scenario Outline: As a user I can fill the contact us form
    Given The user is on the contact us page
    When The user fills the contact us form the following details
      | FirstName       | <FirstName>       |
      | LastName        | <LastName>        |
      | CompanyName     | <CompanyName>     |
      | TelephoneNumber | <TelephoneNumber> |
      | EMail           | <EMail>           |
      | Message         | <Message>         |

    Then The user should be able to submit a message

    Examples:
      | FirstName | LastName | CompanyName         | TelephoneNumber | EMail            | Message       |
      | Kobe      | Bryant   |      ""             |     ""          | kobe@gmail.com   | I am the GOAT |
      | Tracy     | McGrady  | Houston Rockets     | 1413535352      | tmac@gmail.com   | I am the GOAT |
      | Lebron    | James    | Cleveland Cavaliers | 3151351351      | lebron@gmail.com | I am the GOAT |
      | Kyrie     | Irving   | Boston Celtics      | 1313525263      | kyrie@gmail.com  | I am the GOAT |
      | Hakeem    | Olajuwon | Houston Rockets     | 3523562624      | hakeem@gmail.com | I am the GOAT |
