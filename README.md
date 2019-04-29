# AntiBDD
Write browser UI tests with (anti) Gherkin syntax - get your manual testers started with test automation.

Can your manual testers write Java code with Selenium?

No?!

Well, they probably can write steps for a test case... (hopefully)

Can they, maybe, write something like this?

```gherkin
Scenario: Some behavior
  When user navigates to www.some-website.com
  And enters <some text> to some <input-field>
  And clicks element <unique-element>
  And clicks element <other-element>
  And clicks first element <non-unique-element>
  Then element <result-element> contains text <expected-text>
```

AWESOME!

Now you can make them write tests like this, and this project will auto-magically execute them in browser!

AntiBDD is a project that does two things.

## Test automation framework

Firstly, it is a test automation framework.

You can use it to write your automation code in Gherkin syntax (Given, When, Then) with pre-defined building blocks.

For example:

- load page
- click button
- type text
- verify presence of element
- verify that element contains expected text
- etc.

Now, you may (or may not) have noticed, that building tests like this is exactly what BDD shouldn't be like!

... and you are right...

That's where the project gets it's name from :)

## Learning platform

Secondly, AntiBDD is a learning platform.

Now I need to tell you something very personal...

I deeply think, it is my mission to encourage and empower manual testers to step into test automation.

I understand that they might be fearful about this transition, but your company needs test automation, and they need to upskill...

And so the AntiBDD comes with Lessons and Challenges that will help your testers achieve two things.

### Jetpack start

The project contains everything you need (almost) to write and execute first automated test.

My goal is to remove all friction there might possibly be, with intention to remove as much configuration as possible.

You should be able to download this project, import it to your favorite IDE (IntelliJ of course) and start writing tests.

The tests will execute in Chrome and you will get a nice report as a result!

You can find more information, with images from project on [screenshots] website.

Don't know where to start? **Lesson 1** that comes with this project will guide you through your first baby steps!

You will learn the basic building blocks (commands) and how to identify elements on web with id, css or xpath.

### Get the rid of Anti

```gherkin
Scenario: First automation experience
  Given your testers write their first tests
  When they run the project
  And the Chrome window auto-magically opens
  And the test executes itself
  And the report will be beautiful
  Then they will be totally excited
```
**And so will be you!**

However, the mission doesn't end here.

Are your testers getting confident about the tests and making many of them?! **Perfect!!**

But this is not all there is...

Now it is a good time to learn how to reuse the elements. Jump into **Lesson 2** to learn why and how to reuse elements.

The AntiBDD project has a reuse mechanism, which they can use while **still not writing any code!**

Now, they have got a taste of what it is like to automate tests.

They have bunch of them and like to watch them execute without touching the mouse.

And then they like to look at the report for a while.

Boom! **Lesson 3** will meet them with the ultimate challenge.

In this lesson, they will learn how to reuse the whole flows (behaviors, groups of steps, you name it...).

The goal for **Lesson 3** is this:

```gherkin
  # We will get from this:
  Scenario: Google search - Zurich airport (verbose)
    When user navigates to <http://www.google.com>
    And enters text <Zurich airport> to <input-field>
    And clicks element <submit-search>
    Then element <google-result> contains text <Zurich airport>

  # To this:
  Scenario: Google search - Zurich airport (gherkin)
    When user performs Google search of phrase <Zurich airport>
    Then phrase <Zurich Airport> is shown in results

  # And maybe even to this:
  Scenario Outline: Google search - with parameters
    When user performs Google search of phrase <search phrase>
    Then phrase <expected result> is shown in results
    Examples:
    | search phrase         | expected result     |
    | Zurich airport        | Zurich airport      |
    | Basel airport         | Basel airport       |
```

Yes, this will require some programming. Not much. Basics. It is easy enough to call every quitter names.

This is how we get rid of Anti in AntiBDD.

### What next?

Ok, the advertisment is over. If you got this far, you want this!

Go to this link, it will explain the [setup]!

[screenshots]: <https://github.com/PeterKazimir/AntiBDD/wiki/Screenshots-from-the-project>
[setup]: <https://github.com/PeterKazimir/AntiBDD/wiki>
