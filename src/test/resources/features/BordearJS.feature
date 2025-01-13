Feature: Probar la funcionalidad de bordear elementos con JS

  @Bordear
  Scenario: Ingresar usuario correctamente
    Given I am on the login page
    When I enter a username and password
    And click on the login button
    Then entry to the page