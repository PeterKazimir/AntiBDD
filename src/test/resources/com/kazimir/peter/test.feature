Feature: Google search

  Background:
    Given use page.objects

  Scenario: Search test automation
    When go to http://www.google.com
    And enter text test automation to inputField
    And click element googleLogo
    And click element submitSearch
    And click first element css=h3.r > a
    Then element wikiH1 contains text Test automation
    And wait 5

  Scenario: Search zurich airport
    When go to http://www.google.com
    And enter text zurich airport to inputField
    And click element googleLogo
    And click element submitSearch
    And click first element googleResult
    Then element id=flight-plan is displayed
    And wait 5