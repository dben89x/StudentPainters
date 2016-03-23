#returns an integer
#divides parameter coverage by parameter squareFeet
#result of division is a double
#result is then rounded up to nearest integer value, to only allow whole gallons of paint
#new integer is derived from value of result's double value

Feature: Calculate Section Gallons

  Scenario Outline: calcSectionGallons is run with no errors
    Given the following data table for parameters
    When "squareFeet" is <Square Feet>
    And "coverage" is <Coverage>
    Then "result" should be <Output>
    And "result.getType()" should be "Integer"

    Examples:
      | Square Feet | Coverage | Output |
      |       2500 |      250 |     10 |
      |       1525 |      250 |      7 |
      |        500 |      140 |      4 |
      |        250 |        0 |      0 |
