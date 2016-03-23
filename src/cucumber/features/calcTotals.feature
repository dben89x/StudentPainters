#Initializes three counters - double totalSquareFeet, double totalCost, Integer totalGallons
#Iterates over each Section in ArrayList sectionList, belonging to this Estimator's Estimate instance
#Increments totalSquareFeet counter by each Section's squareFeet
#Increments totalCost counter by each Section's cost
#Increments totalGallons counter by each Section's paintGallons
#Assigns value of totalSquareFeet counter to this estimate's totalSquareFeet
#Assigns value of totalCost counter to this estimate's totalCost
#Assigns value of totalGallons counter to this estimate's totalGallons

Feature: Calculate Totals

  Scenario Outline: calcTotals is run with no errors
    Given the following data table for parameters
    When "totalSquareFeet" is <Total Square Feet>
    And "totalCost" is <Total Cost>
    And "totalGallons" is <Total Gallons>
    Then "squareFeetCounter" should be "7050"
    And "costCounter" should be "2100"
    And "gallonsCounter" should be "31"

    Examples:
      | Section | Total Square Feet | Total Cost | Total Gallons |
      |       1 |              2500 |        750 |            10 |
      |       2 |              1500 |        450 |             7 |
      |       3 |               500 |        100 |             3 |
      |       4 |              2550 |        800 |            11 |
