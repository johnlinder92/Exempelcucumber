Feature: Configurable password complexity
  As a company admin
  I want to be able to configure password complexity for my employees
  For security purposes
  Scenario: Setting high complexity
    Given I am logged in as a company admin
    And I have selected high complexity in the dropdown
    When I click save
    Then I display the success message "Company successfully saved"
  Scenario: Attempting to create employee password with medium complexity when the settings is set to high
    Given i have created a new user
    And the new user has clicked on the email link to create new password
    And the user has typed in a password of medium complexity
    When the user clicks submit
    Then I display the message "not enought password complexity"
