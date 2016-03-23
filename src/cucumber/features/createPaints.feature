#returns an array of type Paint - paints
#creates 4 instances of Paint, with the following values:
#[values]
#creates array of type Paint, and populates values with the created Paint instances

Feature: Create Paints

  Scenario Outline: Creating Paints
    Given
    When
    Then
    
    Examples:
      | name        | cost | coverage |
      | Super Paint | 25.0 |    150.0 |
      | Duration    | 40.0 |    250.0 |
      | Wood Scapes | 25.0 |    150.0 |
      | Deck Scapes | 25.0 |    100.0 |

