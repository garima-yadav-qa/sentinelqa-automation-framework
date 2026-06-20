Feature: Subscription management
  As a customer
  I want to upgrade my subscription
  So that I get Pro features and correct billing

  @regression
  Scenario: Upgrade from Starter to Pro mid-cycle
    Given I am on the plans page
    When I upgrade to the "pro" plan
    Then the active plan should be "Pro"
    And my next invoice should be prorated and greater than zero

  @regression @integration
  Scenario: CRM record syncs to Salesforce on upgrade
    Given a customer upgrades to the "pro" plan
    When the subscription event is processed
    Then the Salesforce account plan field should equal "Pro"
    And no duplicate account should be created
