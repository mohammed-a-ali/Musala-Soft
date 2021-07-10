Feature: Validate loading page

  Scenario: Check pages URLs
    Given I am on the "home" page
    When I click on "Company" link from navbar
    And I am on the "company" page
    Then I should see the "Leadership Section"
    When I click on "Facebook" icon
    Then I should be directed to Musala FB page
    And Musala Soft profile picture should appears on the new page