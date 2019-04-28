# Welcome to Lesson 2
# This lesson comes with a wiki page:
# https://github.com/PeterKazimir/AntiBDD/wiki/Lesson-2:-Learn-how-to-reuse-your-elements

# At the end of the Lesson 2, you will find a Challenge 2, I challenge you to try it :)

Feature: Lesson 2 - Learn how to reuse your elements

  # Imagine, that in each of your scenarios you want to click on the same button
  # It can look like this:
  Scenario: I will not reuse 1
    When user navigates to www.somepage.com
    And clicks element xpath=//*[contains(@class, 'button-confirm')]
    # ... rest of the Scenario

  Scenario: I will not reuse 2
    When user navigates to www.somepage.com
    And clicks element xpath=//*[contains(@class, 'button-confirm')]
    # ... rest of the Scenario

  Scenario: I will not reuse 3
    When user navigates to www.somepage.com
    And clicks element xpath=//*[contains(@class, 'button-confirm')]
    # ... rest of the Scenario

  # First of all, this is ugly, and very difficult to read.

  # Now imagine, that the xpath of this button has changed.
  # In order to update your tests, you need to update the xpath of this button in each Scenario
  # The button can even be used in many different feature files!

  # But!
  # There is a way to organize your element identifiers in a reusable way and give them nice names!
  # It can look like this:
  Scenario: I will gladly reuse 1
    When user navigates to www.somepage.com
    And clicks element confirm-button
    # ... rest of the Scenario

  Scenario: I will gladly reuse 2
    When user navigates to www.somepage.com
    And clicks element confirm-button
    # ... rest of the Scenario

  Scenario: I will gladly reuse 3
    When user navigates to www.somepage.com
    And clicks element confirm-button
    # ... rest of the Scenario

  # This can be done by specifying the element identifiers in a separate file
  # An example of such file rests in the lesson2 folder with name element.names (this is a regular text file)
  # In this file you will see this:

  # confirm-button === xpath=//*[contains(@class, 'button-confirm')]
  # In other words
  # element name === element identifier (can be id, css, xpath)

  # Now, if the element attribute (xpath) changes, you only need to change it here, in this file.
  # Read more about this concept on the Lesson 2 wiki page