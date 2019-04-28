Feature: Lesson 1

  Scenario: Learn how to add basic commands
    # Let's take a look at a list of basic commands
    # - they don't do anything, this is just a list
    # - you can use them with any keyword - Given, When, And, Then

    When user navigates to www.somewebsite.com
    And enters text some text to element
    And clicks element unique element
    And clicks first element non-unique element
    Then element element contains text expected test
    Then element other element is displayed