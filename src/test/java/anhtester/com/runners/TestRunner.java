package anhtester.com.runners;

import anhtester.com.helpers.PropertiesHelpers;
import anhtester.com.report.AllureManager;
import anhtester.com.utils.Log;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"anhtester.com.projects.website.crm.stepdefinitions"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber-reports.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        , monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("================ BEFORE SUITE ================");
        Log.info("================ BEFORE SUITE ================");
        AllureManager.setAllureEnvironmentInformation();
        PropertiesHelpers.loadAllFiles(); //Load Config and Locators
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("================ AFTER SUITE ================");
        Log.info("================ AFTER SUITE ================");
    }
}
