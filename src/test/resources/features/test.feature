@execute
Feature: Google search

  Background:
    Given use page.objects

  Scenario: Search test automation
    When user navigates to www.google.com
    And enters text test automation to inputField
    And clicks element submitSearch
    And clicks first element googleResult
    Then element wikiH1 contains text Test automation
    And waits 5

  Scenario: Search zurich airport
    When user navigates to http://www.google.com
    And enters text zurich airport to inputField
    And clicks element googleLogo
    And clicks element submitSearch
    And clicks first element googleResult
    Then element id=flight-plan is displayed
    And waits 5