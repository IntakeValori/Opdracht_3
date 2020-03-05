Feature: Test navigation on the valori.nl homepage

  @happy
  Scenario: As a visitor I can navigate the website to read about the Mobile Chapter
    Given I am on the Valori homepage
    And I navigate to the page Mobile Chapter
    Then I can read articles about the Mobile Chapter

  @unhappy
  Scenario: As a visitor I can't sent an empty contact form
    Given I am on the Valori homepage
    And I navigate to the page Mobile Chapter
    And I navigate to the page Contact Valori
    And I fill out the contact form with insufficient details
    And I submit the contact form
    Then I expect an error on the contact form

  @happy
  Scenario: As a visitor I can contact Valori
    Given I am on the Valori homepage
    And I navigate to the page Mobile Chapter
    And I navigate to the page Contact Valori
    And I fill out the contact form with sufficient details
#    @TODO I didn't submit any forms since I only have access to the production environment. I also didn't implement the thank you page because of this. (That should also be minimal effort. Under \pages\ a new file with the structure of the thank you page and an assertion on a title)
#    And I submit the contact form
#    Then I expect to see the page thank you
