package anhtester.com.projects.website.cms.stepdefinitions;

import anhtester.com.keyword.WebUI;
import anhtester.com.projects.website.cms.pages.CommonPage;
import anhtester.com.projects.website.cms.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage;
    CommonPage commonPage;

    @Given("User navigate to Login Page for Admin {string}")
    public void userNavigateToLoginPageForAdmin(String url) {
        WebUI.getURL(url);
    }

    @When("User enter email {string} password {string} and click Login button")
    public void userEnterEmailPasswordAndClickLoginButton(String email, String password) {
        loginPage = new LoginPage();
        commonPage = loginPage.loginCMS(email, password);
    }

    @Then("User is redirected to the Dashboard page")
    public void userIsRedirectedToTheDashboardPage() {
        commonPage.verifyDashboardPageDisplays();
    }
}
