Feature: Search
  Agile Story: As a user, I should be able to search when I am on Google page

  Background: User should be on google search page
    Given User is on the google search page

  @Search
  Scenario: Google default title verification
    Then User should see Google in the title

  @wip #work in progress
  Scenario: Google title verification after search
    When User searches apple
    Then User should see apple in the title



  Scenario: Google title verification after search
    When User searches "peach"
    Then User should see "peach" in the title

  Scenario: Google -About- link page title verification
    Then User should see About link
    And User clicks About link
    Then User should see title Google - About Google, Our Culture & Company News

    @googleTable
  Scenario: Google search page footer links verification
    Then User should see six links in the footer
      | Advertising      |
      | Business         |
      | How Search Works |
      | Privacy          |
      | Terms            |
      | Settings         |