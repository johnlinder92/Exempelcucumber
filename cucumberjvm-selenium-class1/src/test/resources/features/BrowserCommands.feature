Feature: seleniumframework.com features
  Scenario: Open seleniumframework website
    Given I open seleniumframework website
    And I navigate to ABOUT link
    Then I print the html title
  Scenario: Browser commands
    Given I open seleniumframework website
    Then I perform selenium browser commands