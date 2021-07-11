Feature: Print open jobs

  Scenario: Print open jobs by location
    Given I am on the "home" page
    When I click on "Careers" link from navbar
    And I am on the "Careers" page
    When I click on "Check our open positions"
    And I am on the "careers/join-us" page
    And I select below locations from "get_location" dropdown and see opn jobs in console
      | Location |
      | Sofia    |
      | Skopje   |