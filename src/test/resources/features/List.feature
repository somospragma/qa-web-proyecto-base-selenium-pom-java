Feature: Test list funtionality 
    
@testList
    Scenario Outline: validate that a text is present inside the list
        Given Navigate to the list page
        When Search <state> in the list
        Then the city <city> exist in the list 

        Examples:
            | state       | city                |
            | Washington  | Seattle, Washington |
            | Chicago     | Chicao, Illinois   |


   