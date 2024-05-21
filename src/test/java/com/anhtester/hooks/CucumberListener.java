package com.anhtester.hooks;

import com.anhtester.driver.DriverManager;
import com.anhtester.keywords.WebUI;
import com.anhtester.utils.EmailSendUtils;
import com.anhtester.utils.LogUtils;
import com.anhtester.utils.ZipUtils;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static com.anhtester.constants.FrameworkConstants.DELETE_TEMP_FOLDER;
import static com.anhtester.constants.FrameworkConstants.YES;

public class CucumberListener implements EventListener {

    //Khai báo các biến để thống kê tổng số test cases sau khi kết thúc test
    public static int count_totalTCs = 0;
    public static int count_passedTCs = 0;
    public static int count_skippedTCs = 0;
    public static int count_failedTCs = 0;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        //Set all events that need use (public). Override from EventListener
        publisher.registerHandlerFor(TestRunStarted.class, this::runStarted);
        publisher.registerHandlerFor(TestRunFinished.class, this::runFinished);
        publisher.registerHandlerFor(TestSourceRead.class, this::featureRead);
        publisher.registerHandlerFor(TestCaseStarted.class, this::ScenarioStarted);
        publisher.registerHandlerFor(TestCaseFinished.class, this::ScenarioFinished);
        publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);
    }

    // Execute after @After in hook
    private void runStarted(TestRunStarted event) {
        LogUtils.info("********* RUN STARTED *********");
    }

    // Execute after @After in hook
    private void runFinished(TestRunFinished event) {
        LogUtils.info("********* RUN FINISHED *********");
    }

    // This event is triggered when feature file is read
    // here we create the feature node
    private void featureRead(TestSourceRead event) {
//        String featurePath = event.getUri().toString();
//        String featureName = featurePath.split(".*/")[1];
//        LogUtils.info("Feature Path: " + featurePath);
//        LogUtils.info("Feature Name: " + featureName);
    }

    private void ScenarioStarted(TestCaseStarted event) {
//        LogUtils.info("Scenario Path: " + event.getTestCase().getUri().toString());
//        LogUtils.info("Scenario Name: " + event.getTestCase().getName());
        count_totalTCs = count_totalTCs + 1;
    }

    private void ScenarioFinished(TestCaseFinished event) {
        Result result = event.getResult();

        if (Status.PASSED.equals(result.getStatus())) {
            count_passedTCs = count_passedTCs + 1;
        }
        if (Status.FAILED.equals(result.getStatus())) {
            count_failedTCs = count_failedTCs + 1;
        }
        if (Status.SKIPPED.equals(result.getStatus())) {
            count_skippedTCs = count_skippedTCs + 1;
        }
    }

    // Step started event
    private void stepStarted(TestStepStarted event) {
        String stepName = "";
        String keyword = "";

        // Check whether the event is from a hook or step
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

    // This is triggered when test Step is finished
    private void stepFinished(TestStepFinished event) {
        Result result = event.getResult();

        if (Status.PASSED.equals(result.getStatus())) {

        }
        if (Status.FAILED.equals(result.getStatus())) {

        }
        if (Status.SKIPPED.equals(result.getStatus())) {

        }
    }

}
