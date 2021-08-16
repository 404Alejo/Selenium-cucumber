Feature: Make a search in amazon
  Scenario:
    Given the user navigates to www.amazon.com
    And Searches for 'Alexa'
    And navigates to the second page
    And selects the third item
    Then assert that the item would be available for purchase (the user would be able to add it to the car)