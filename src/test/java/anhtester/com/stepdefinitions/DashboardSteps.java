package anhtester.com.stepdefinitions;

import anhtester.com.driver.DriverManager;
import anhtester.com.utils.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardSteps {

    @Given("user navigate to dashboard")
    public void userNavigateToDashboard() {
        WebUI.logConsole("Driver on DashboardSteps class: " + DriverManager.getDriver());
        WebUI.getToUrl("https://hrm.anhtester.com/erp/login");
        WebUI.sleep(1);
        WebUI.setText(By.xpath("//input[@id='iusername']"), "admin01");
        WebUI.setText(By.xpath("//input[@id='ipassword']"), "123456");
        WebUI.clickElement(By.xpath("//button[@type='submit']"));
    }

    @When("user click {string}")
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
