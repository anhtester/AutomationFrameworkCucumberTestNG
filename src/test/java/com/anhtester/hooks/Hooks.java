package com.anhtester.hooks;

import com.anhtester.driver.DriverManager;
import com.anhtester.helpers.CaptureHelpers;
import com.anhtester.helpers.PropertiesHelpers;
import com.anhtester.keywords.WebUI;
import com.anhtester.report.AllureManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.anhtester.constants.FrameworkConstants.VIDEO_RECORD;
import static com.anhtester.constants.FrameworkConstants.YES;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @BeforeAll
    public static void before_all() {
        System.out.println("================ BEFORE ALL ================");
        PropertiesHelpers.loadAllFiles(); //Load Config and Locators
        AllureManager.setAllureEnvironmentInformation(); //Setup Allure Report
    }

    @AfterAll
    public static void after_all() {
        System.out.println("================ AFTER ALL ================");
        
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        //System.out.println("Starting Driver in Hooks: " + DriverManager.getDriver());
        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            CaptureHelpers.startRecord(scenario.getName());
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        //System.out.println("Stop Driver in Hooks: " + DriverManager.getDriver());
        WebUI.sleep(1);

        if (VIDEO_RECORD.toLowerCase().trim().equals(YES)) {
            CaptureHelpers.stopRecord();
        }

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
