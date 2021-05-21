Feature: Query Product
  Scenario: Query Petistos
    Given I access the Cobasi page in Portuguese
    When I query "petiscos"
    Then The page title contains the expression "Petiscos - Cobasi"

    When I select "Petisco Snack Origem Natural Calming Care"
    Then The page title is "Petisco Snack Origem Natural Calming Care"
    And The product name is "Petisco Snack Origem Natural Calming Care"
    And The price is "R$ 6,90"

