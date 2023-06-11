Feature: All books list
@wip
  Scenario: User should be able to see the book collection
    Given User should see book collection
    Then User should verifyStatusCode of seeing book collection
