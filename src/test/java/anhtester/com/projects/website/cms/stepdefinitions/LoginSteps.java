package anhtester.com.projects.website.cms.stepdefinitions;

import anhtester.com.hooks.TestContext;
import anhtester.com.keywords.WebUI;
import anhtester.com.projects.website.cms.pages.CommonPageCMS;
import anhtester.com.projects.website.cms.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage;
    CommonPageCMS commonPageCMS;

    public LoginSteps(TestContext testContext) {
        loginPage = testContext.getLoginPage();
        commonPageCMS = testContext.getCommonPage();
    }

    @Given("User navigate to Login Page for Admin {string}")
    public void userNavigateToLoginPageForAdmin(String url) {
        WebUI.getURL(url);
    }

    @When("user enter email {string} password {string}")
    public void userEnterEmailPasswordAndClickLoginButton(String email, String password) {
        commonPageCMS = loginPage.loginCMS(email, password);
    }

    @And("click Login button")
    public void clickLoginButton() {
    }

    @Then("user is redirected to the Dashboard page")
    public void userIsRedirectedToTheDashboardPage() {
        commonPageCMS.verifyDashboardPageDisplays();
    }

}
