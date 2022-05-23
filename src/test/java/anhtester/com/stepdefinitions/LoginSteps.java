package anhtester.com.stepdefinitions;

import anhtester.com.driver.DriverManager;
import anhtester.com.utils.WebUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginSteps {

    @Given("user navigate to url {string}")
    public void userNavigateToUrl(String url) {
        WebUI.logConsole("Driver on LoginSteps class: " + DriverManager.getDriver());
        WebUI.getToUrl(url);
    }

    @When("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String email, String password) {
        WebUI.setText(By.xpath("//input[@id='iusername']"), email);
        WebUI.setText(By.xpath("//input[@id='ipassword']"), password);
    }

    @And("click login button")
    public void clickLoginButton() {
        WebUI.sleep(1);
        WebUI.clickElement(By.xpath("//button[@type='submit']"));
    }

    @Then("The user redirect to Dashboard page")
    public void theUserRedirectToDashboardPage() {
        WebUI.waitForPageLoaded();
        WebUI.waitForJQueryLoaded();
        WebUI.sleep(1);
        Assert.assertTrue(false, "Lỗi rồi");

    }
}
