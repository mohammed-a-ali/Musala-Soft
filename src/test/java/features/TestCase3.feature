Feature: Apply an open Job

  Scenario: Apply job using invalid data
    Given I am on the "home" page
    When I click on "Careers" link from navbar
    And I am on the "Careers" page
    When I click on "Check our open positions"
    And I am on the "careers/join-us" page
    And I select "Anywhere" from "get_location" dropdown
    And I choose "Node.js Developer" from open jobs
    Then I should see the "General description" in the join-us page
    And I should see the "Requirements" in the join-us page
    And I should see the "Responsibilities" in the join-us page
    And I should see the "What we offer" in the join-us page
    When I click on Apply button
    And I fill the fields using invalid data
    And I click on Send button
    And I click on Close button
    Then I should see some validation errors