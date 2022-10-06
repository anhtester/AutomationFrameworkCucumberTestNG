package anhtester.com.projects.website.crm.stepdefinitions;

import anhtester.com.common.CommonPage;
import anhtester.com.keyword.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps extends CommonPage {

    @Given("User navigate to url {string}")
    public void userNavigateToUrl(String url) {
        //WebUI.getURL(url);
    }

    @When("User login with username {string} and password {string} valid")
    public void userLoginWithUsernameAndPasswordValid(String email, String password) {
        getSignInPage().signIn(email, password);
    }

    @When("User login with username {string} and password {string} invalid")
    public void userLoginWithUsernameAndPasswordInvalid(String email, String password) {
        getSignInPage().signIn(email, password);
    }

    @Then("The user redirect to Dashboard page")
    public void theUserRedirectToDashboardPage() {
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(getDashboardPage().pageUrl), "Can not redirect to the dashboard page");
    }

    @Then("The user can not redirect to Dashboard page")
    public void theUserCanNotRedirectToDashboardPage() {
        WebUI.verifyElementNotPresent(getSignInPage().labelEmailError, "FAIL. User sign in successfully");
    }

    @And("The error message is displays")
    public void theErrorMessageIsDisplays() {
        WebUI.verifyElementPresent(getSignInPage().alertErrorMessage, "The error message does not display");
    }
}
