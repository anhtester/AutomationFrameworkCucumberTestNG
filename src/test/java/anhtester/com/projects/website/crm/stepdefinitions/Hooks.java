package anhtester.com.projects.website.crm.stepdefinitions;

import anhtester.com.driver.DriverManager;
import anhtester.com.utils.WebUI;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void beforeScenario() {
        //System.out.println("Starting Driver in Hooks: " + DriverManager.getDriver());
    }


    @After
    public void afterScenario(Scenario scenario) {
        //System.out.println("Stop Driver in Hooks: " + DriverManager.getDriver());
        WebUI.sleep(1);
        DriverManager.quit();
        WebUI.stopSoftAssertAll();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        //validate if scenario has failed then Screenshot
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");

            //AllureManager.takeScreenshotStep();
        }
    }

}
