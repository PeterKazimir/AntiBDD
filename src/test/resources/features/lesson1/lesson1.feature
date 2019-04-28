# Welcome to Lesson 1
# This lesson comes with a wiki page:
# https://github.com/PeterKazimir/AntiBDD/wiki/Lesson-1:-Learn-basic-commands-and-how-to-identify-elements

# At the end of the Lesson 1, you will find a Challenge 1, I challenge you to try it :)

Feature: Lesson 1 - Learn how to add basic commands

  Scenario: Basic commands
    # Let's take a look at a list of basic commands
    # - they don't do anything, this is just a list
    # - you can use them with any keyword - Given, When, And, Then

    When user navigates to www.somewebsite.com
    And enters text some text to element
    And clicks element unique element
    And clicks first element non-unique element
    Then element element contains text expected test
    Then element other element is displayed

  Scenario: Learn how to identify elements
    # Now let's take a look at how we can identify elements
    # - by id
    # - by css
    # - by xpath

    And clicks element id=someId
    And clicks element css=.someClass
    And clicks element xpath=//*[someXpath]