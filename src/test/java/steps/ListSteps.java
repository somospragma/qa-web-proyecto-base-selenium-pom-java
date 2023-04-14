package steps;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ListPage;

public class ListSteps {

    //creo la instacia list apartir de la referencia ListPage
    ListPage list = new ListPage();

    @Given("^Navigate to the list page$")
    public void navigateToListPage(){
        list.navigateToListPage();
    }

    @When("^Search (.+) in the list$")
    public void searchInlist(String state) throws InterruptedException{
        list.enterSearchCriteria(state);
    }

    @Then("^the city (.+) exist in the list$")
    public void validateResults(String city){
        List<String> lista = list.getAllSearchResults();
        boolean textIsThere = lista.contains(city);

        if(textIsThere){
            System.out.println("the text is on the list, PASSED.");
        }else{
            throw new Error("the text isn't on the list, FAILED.");
        }

        
    }
        
}
