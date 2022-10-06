package anhtester.com.runners;

import anhtester.com.helpers.PropertiesHelpers;
import anhtester.com.report.AllureManager;
import anhtester.com.utils.DateUtils;
import anhtester.com.utils.ReportUtils;
import anhtester.com.utils.ZipUtils;
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
        , monochrome = true,
        tags = "@Regression or @Smoke"
)

public class TestRunnerAllFeatureByTag extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("================ BEFORE SUITE ================");
        PropertiesHelpers.loadAllFiles(); //Load Config and Locators
        AllureManager.setAllureEnvironmentInformation(); //Setup Allure Report
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("================ AFTER SUITE ================");
        ZipUtils.zip();
        ReportUtils.openReports("CucumberReports/cucumber-reports/cucumber-html-reports/overview-features.html");
        ReportUtils.openReports("CucumberReports/CucumberExtentReport "+ DateUtils.getCurrentDate("dd-MM-YYYY") +"/ExtentReport.html");
    }
}
