
Feature: Verify get info in the API

  Scenario Outline: Assert on the response body and HTTP status code
    Given Get Call to "<url>"
    Then Response Code = "<responseMessage>"
    And Name is "<name>"
    And Postman ID is "<id>"
    And Schema is "<schema>"
    And Description is "<description>"

    Examples:
      |   url    | responseMessage |     name        |                  id                  |                       schema                                         | description |
      |  info    |    200          | Automation Test | 9f17fbe0-c67c-32b8-9c8f-6f2cb0d2f9e5 | https://schema.getpostman.com/json/collection/v2.0.0/collection.json |             |