#returns a double
#multiplies parameter cost by parameter sectionGallons
#returns result of type double

Feature: Calculate Section Cost
  Scenario Outline: calcSectionCost is run with no errors
	  Given the following data table for parameters
	  When "paintCost" is <Paint Cost>
	  And "sectionGallons" is <Gallons>
	  Then "result" should be <Output>
	  And "result.getType()" should be "double"
	  
	  Examples: 
      | Paint Cost | Gallons | Output |
      |         25 |       5 |    125 |
      |         50 |      10 |    500 |
      |          0 |       5 |      0 |
      |         25 |       0 |      0 |