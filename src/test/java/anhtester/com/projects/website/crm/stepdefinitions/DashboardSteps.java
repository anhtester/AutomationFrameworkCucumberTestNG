package anhtester.com.projects.website.crm.stepdefinitions;

import anhtester.com.common.CommonSteps;
import anhtester.com.driver.DriverManager;
import anhtester.com.utils.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardSteps extends CommonPage {

    public DashboardSteps(){

    }

    @Given("User logged in with email {string} and password {string}")
    public void userLoggedInWithEmailAndPassword(String email, String password) {
        WebUI.getToUrl("https://hrm.anhtester.com/erp/login");
        WebUI.setText(By.xpath("//input[@id='iusername']"), email);
        WebUI.setText(By.xpath("//input[@id='ipassword']"), password);
        WebUI.clickElement(By.xpath("//button[@type='submit']"));
    }

    @Given("User navigate to dashboard")
    public void userNavigateToDashboard() {
        WebUI.verifyPageUrl(dashboardPage.pageUrl);
    }

    @When("User click {string}")
    public void userClick(String menu) {
        WebUI.waitForPageLoaded();
        WebUI.waitForJQueryLoaded();
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath("//span[contains(text(),'" + menu + "')]"));
    }

    @Then("The user redirect to this page")
    public void theUserRedirectToThisPage() {
        WebUI.waitForPageLoaded();
        WebUI.sleep(1);
        Assert.assertTrue(true);
    }

}
