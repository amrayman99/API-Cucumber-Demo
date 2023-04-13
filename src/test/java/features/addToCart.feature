Feature: Checkout
  Scenario: Checkout without entering FullName
    Given User open website and choose iPhone
    When User fill Personal info without entering FullName
    |OmarEbnElKhtaab|123|2|3|Pharmacy in front of Building|Amr Ayman|
    Then Error message will appear