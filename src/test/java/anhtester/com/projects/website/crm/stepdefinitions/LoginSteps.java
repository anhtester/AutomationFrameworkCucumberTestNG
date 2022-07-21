package anhtester.com.projects.website.crm.stepdefinitions;

import anhtester.com.utils.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonPage {

    @Given("User navigate to url {string}")
    public void userNavigateToUrl(String url) {
        WebUI.getToUrl(url);
    }

    @When("User login with username {string} and password {string} valid")
    public void userLoginWithUsernameAndPasswordValid(String email, String password) {
        signInPage.signIn(email, password);
    }

    @When("User login with username {string} and password {string} invalid")
    public void userLoginWithUsernameAndPasswordInvalid(String email, String password) {
        signInPage.signIn(email, password);
    }

    @Then("The user redirect to Dashboard page")
    public void theUserRedirectToDashboardPage() {
        WebUI.waitForPageLoaded();
        WebUI.waitForJQueryLoaded();
        WebUI.verifyPageUrl(dashboardPage.pageUrl, "Can not redirect to the dashboard page");
    }

    @Then("The user can not redirect to Dashboard page")
    public void theUserCanNotRedirectToDashboardPage() {
        WebUI.verifyElementNotPresent(signInPage.labelEmailError, "FAIL. User sign in successfully");
    }

    @And("The error message is displays")
    public void theErrorMessageIsDisplays() {
        WebUI.verifyElementPresent(signInPage.labelAuthentication, "The error message does not display");
    }
}
