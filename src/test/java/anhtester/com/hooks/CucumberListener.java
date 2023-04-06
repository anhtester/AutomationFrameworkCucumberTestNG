package anhtester.com.hooks;

import anhtester.com.constants.FrameworkConstants;
import anhtester.com.helpers.CaptureHelpers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CucumberListener implements EventListener {

    public static int count_totalTCs;
    public static int count_passedTCs;
    public static int count_skippedTCs;
    public static int count_failedTCs;

    public CucumberListener() {
    }

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        /*
         * :: is method reference , so this::collecTag means collectTags method in
         * 'this' instance. Here we says runStarted method accepts or listens to
         * TestRunStarted event type
         */
        publisher.registerHandlerFor(TestRunStarted.class, this::runStarted);
        publisher.registerHandlerFor(TestRunFinished.class, this::runFinished);
        publisher.registerHandlerFor(TestSourceRead.class, this::featureRead);
        publisher.registerHandlerFor(TestCaseStarted.class, this::ScenarioStarted);
        publisher.registerHandlerFor(TestCaseFinished.class, this::ScenarioFinished);
        publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);

    }

    /*
     * Here we set argument type as TestRunStarted if you set anything else then the
     * corresponding register shows error as it doesn't have a listner method that
     * accepts the type specified in TestRunStarted.class
     */

    // Here we create the reporter
    private void runStarted(TestRunStarted event) {

    }

    // TestRunFinished event is triggered when all feature file executions are completed
    private void runFinished(TestRunFinished event) {

    }

    // This event is triggered when feature file is read
    // here we create the feature node
    private void featureRead(TestSourceRead event) {
        String featureSource = event.getUri().toString();
        String featureName = featureSource.split(".*/")[1];
        System.out.println("Feature Source: " + featureSource);
        System.out.println("Feature Name: " + featureName);
    }

    // This event is triggered when Test Case is started
    // here we create the scenario node
    private void ScenarioStarted(TestCaseStarted event) {
        String featureName = event.getTestCase().getUri().toString();
        System.out.println("Feature Name: " + featureName);

        count_totalTCs = count_totalTCs + 1;
    }

    private void ScenarioFinished(TestCaseFinished event) {
        String featureName = event.getTestCase().getUri().toString();

        if (event.getResult().getStatus().toString() == "PASSED") {
            count_passedTCs = count_passedTCs + 1;
        } else if (event.getResult().getStatus().toString() == "SKIPPED") {
            count_skippedTCs = count_skippedTCs + 1;
        } else {
            count_failedTCs = count_failedTCs + 1;
        }
    }

    // step started event
    // here we create the test node
    private void stepStarted(TestStepStarted event) {

        String stepName = "";
        String keyword = "";

        // We check whether the event is from a hook or step
        if (event.getTestStep() instanceof PickleStepTestStep) {
            // TestStepStarted event implements PickleStepTestStep interface
            // Which have additional methods to interact with the event object
            // So we have to cast TestCase object to get those methods
            PickleStepTestStep steps = (PickleStepTestStep) event.getTestStep();
            stepName = steps.getStep().getText();
            keyword = steps.getStep().getKeyword();

        } else {
            // Same with HookTestStep
            HookTestStep hoo = (HookTestStep) event.getTestStep();
            stepName = hoo.getHookType().name();

        }

    }

    // This is triggered when TestStep is finished
    private void stepFinished(TestStepFinished event) {
        if (event.getResult().getStatus().toString() == "PASSED") {

        } else if (event.getResult().getStatus().toString() == "SKIPPED") {

        } else {

        }
    }

}
