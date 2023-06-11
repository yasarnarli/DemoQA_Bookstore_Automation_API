@wip
Feature: Register new user, add books and try crude functions


  Scenario: User should be able to register new user
    Given User should register with valid credentials
    Then User should verify the registerStatusCode


    Scenario: User should be able to generate new token
      Given User should input valid credentials
      Then User should verifyStatusCode of generating new token


  Scenario: User should be able to authorized
    Given User should be authorized
    Then User should verifyStatusCode of authorizing


    Scenario: User should be able to add books
      Given User should add  books
      Then User should verifyStatusCode of adding book

      Scenario: User should be able to update collection
        Given User should update collection
        Then User should verifyStatusCode of updating


  Scenario: User should be able to get user info
    Given User should get the user info
    Then User should verifyStatusCode of getUserInfo


  Scenario: User should be able to delete the book
          Given User should delete the book
          Then User should verifyStatusCode of Deleting the book

  Scenario: User should be able to get user info
    Given User should get the user info
    Then User should verifyStatusCode of getUserInfo







