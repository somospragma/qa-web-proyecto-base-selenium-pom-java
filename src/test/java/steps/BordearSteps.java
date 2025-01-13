package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.BordearPage;

public class BordearSteps {

    BordearPage bordearPage =  new BordearPage();

    @Given("I am on the login page")
    public void navigateToLogin() {
        bordearPage.navigateToLogin();
    }


    @When("I enter a username and password")
    public void iEnterAUsernameAndPassword() {
        bordearPage.enterUsername("standard_user");
        bordearPage.enterPassword("secret_sauce");
    }

    @And("click on the login button")
    public void clickOnTheLoginButton() {
        bordearPage.clickLogin();
    }

    @Then("entry to the page")
    public void entryToThePage() {
        bordearPage.addProduct();
    }
}
