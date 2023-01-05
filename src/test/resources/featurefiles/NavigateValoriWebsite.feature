Feature: Test navigation on the valori.nl homepage

  Scenario: As a user I can navigate the website to read about the Mobile Chapter
    Given I am on the Valori homepage
    When I navigate to the Mobile Chapter page
    Then I can read articles about the Mobile Chapter


  Scenario: As a user I can navigate to the contact form from the FST page
    Given I am on the Valori homepage
    And I navigate to the Mobile Chapter page
    When I contact Valori
    Then The contact us form is available


  Scenario:  As a user I submit a contact form
    Given I am on the Valori homepage
    And I navigate to the Mobile Chapter page
    When I contact Valori
    And I fill in a contact form with personal details
      |Firstname|Lastname|Company name|Phone number|E-mail|Message|
      |Emma|Doe|Testing V.G|0621000000|emma@testing.com|Message|
      |James|Dart|[blank]|[blank]|james@testing.com|Message|
      |Troy|Johnson|Testing V.G|0611000000|troy@testing.com|Message|
#  This step is commented out - no submission form for this opdracht
#    #    Then Page shows confirmation on successful submission















