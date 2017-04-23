Feature: Issue to user
  Scenario: Scenario_1
    Given Log in as "administrator"
    And Open create Task page and Create Task using "issue_1"
    And Check that "issue_1" was created
    And Log out
    And Log in as "user_1"
    Then "user_1" see that issue was created