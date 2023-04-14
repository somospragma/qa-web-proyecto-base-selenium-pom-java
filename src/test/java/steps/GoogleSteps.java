package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I am on the Google search page$")
    public void navigateToGoogle() {

        google.navigateToGoogle();

    }

    @When("^I enter a searcj criteria$")
    public void enterSearchCriteria() {
        google.enterSearchCriteria("Hola Colombia");
    }

    @And("^click on the search button$")
    public void clickSearchCriteria() {

        google.clickGoogleSeach();

    }

    @Then("^the results match the criteria$")
    public void validateResults() {
        //si se quiere que el texto de un elemento sea igual
        Assert.assertEquals("Hola Colombia: últimas noticias e imágenes - Revista ¡HOLA!", google.firstResult());
        //si se quiere validar que este el elemento
        Assert.assertTrue("el elemento si esta",google.FirstResultStatus());
        //si se quiere validar que no este el elemento
        //Assert.assertFalse("el elemento si esta",google.FirstResultStatus());
    }

}
