Feature: Validate inclusion of the 'Estado Código' column

  Scenario: Export Claim Accounting Report and verify 'Estado Código' column
    Given I have logged into the application
    When I export the 'Claim Accounting Report'
    Then the report should be downloaded successfully
    And the 'Estado Código' column should be correctly positioned in the Excel file