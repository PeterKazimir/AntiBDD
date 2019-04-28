# Welcome to Lesson 3
# This lesson comes with a wiki page:
# https://github.com/PeterKazimir/AntiBDD/wiki/Lesson-3:-Learn-how-to-reuse-behaviors

# At the end of the Lesson 3, you will find a Challenge 3, I challenge you to try it :)

Feature: Lesson 3 - Learn how to reuse behaviors

  # In the Lesson 2 we looked at how to reuse element identifier by giving it a name
  # In this lesson, we would like to identify behaviors
  # This will help us reuse whole "flows" and will make our tests even more readable!

  # We will get from this:
  Scenario: Google search - Zurich airport (verbose)
    When user navigates to http://www.google.com
    And enters text zurich airport to inputField
    And clicks element googleLogo
    And clicks element submitSearch
    And clicks first element googleResult
    Then element googleResult contains text zurich airport

  # To this:
  Scenario: Google search - Zurich airport (gherkin)
    When user performs Google search of phrase Zurich airport
    Then phrase Zurich airport is shown in results

  # And maybe even to this:
  Scenario Outline: Google search - with parameters
    When user performs Google search of phrase <search phrase>
    Then phrase <expected result> is shown in results
    Examples:
    | search phrase         | expected result     |
    | Zurich airport        | Zurich airport      |
    | Basel airport         | Basel airport       |
  # You might have guessed it by now,
  # the Scenario Outline will execute the test case for each row of Examples.
  # This is very powerful!