Feature: Get the data from given API and fill the contact form

  Scenario: Create Get request and fill the contact form
    When I create get request from "https://randomuser.me/api/"
    And Verify the status code is 200
    And Verify the content type is "application/json; charset=utf-8"
    And The user is on the contact us page
    Then Fill the contact form with the data comes from given API