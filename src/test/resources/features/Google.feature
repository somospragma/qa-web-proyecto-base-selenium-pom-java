Feature: Probar la funcionalidad de busqueda en Google

//el Background sirve para ejecutar una accion en todos los escenarios 
//Background: I am on the Google search page

//la regla solo es indicativa, indica que regla del bussines se estan probando con los escenarios del Feature
Rule: the user can searh anythig on the google page

    @run_1
    Scenario: Busco algo en Google
        Given I am on the Google search page
        When I enter a searcj criteria
        And click on the search button
        Then the results match the criteria
        