Feature: Check careers

  Scenario: Select from dropdown
    Given I am on the "home" page
    When I click on "Careers" link from navbar
    And I am on the "Careers" page
    When I click on "Check our open positions" button
    And I am on the "careers/join-us" page
    And I select "Anywhere" from "get_location" dropdown