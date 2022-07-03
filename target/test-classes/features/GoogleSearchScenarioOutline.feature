Feature: Search
  Agile Story: As a user, I should be able to search when I am on Google page

@scenarioOutline
  Scenario Outline: Google title verification after search
    Given User is on the google search page
    When User searches "<searchValue>"
    Then User should see "<expectedTitle>" in the title
    Examples:
      | searchValue | expectedTitle |
      | apple       | apple         |
      | kiwi        | kiwi          |