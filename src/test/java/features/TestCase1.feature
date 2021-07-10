Feature: Fill about data

  Scenario: Fill data from excel file
    Given I am on the "home" page
    When I click on "Contact us" button
    And I fill the below textBoxes from excel
      | About Data   |
      | Name         |
      | Email        |
      | Subject      |
      | Your Message |