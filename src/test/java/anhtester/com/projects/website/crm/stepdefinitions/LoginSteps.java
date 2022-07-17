package anhtester.com.projects.website.crm.stepdefinitions;

import anhtester.com.utils.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonPage {

    @Given("user navigate to url {string}")
    public void userNavigateToUrl(String url) {
        WebUI.getToUrl(url);
    }

    @When("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String email, String password) {
        signInPage.signIn(email, password);
    }

    @And("click login button")
    public void clickLoginButton() {
        WebUI.verifyElementNotPresent(signInPage.email_error, "Email or Password not match.");
    }

    @Then("The user redirect to Dashboard page")
    public void theUserRedirectToDashboardPage() {
        WebUI.waitForPageLoaded();
        WebUI.waitForJQueryLoaded();
        WebUI.sleep(5);
    }
}
