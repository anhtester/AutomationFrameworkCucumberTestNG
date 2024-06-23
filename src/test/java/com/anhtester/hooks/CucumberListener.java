package com.anhtester.hooks;

import com.anhtester.helpers.PropertiesHelpers;
import com.anhtester.helpers.SystemHelpers;
import com.anhtester.utils.LogUtils;
import com.anhtester.utils.ReportUtils;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

public class CucumberListener implements EventListener {

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
        //ReportUtils.openReports(SystemHelpers.getCurrentDir() + PropertiesHelpers.getValue("extent.reporter.spark.out"));
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
    }

    private void ScenarioFinished(TestCaseFinished event) {
//        Result result = event.getResult();
//
//        if (Status.PASSED.equals(result.getStatus())) {
//
//        }
//        if (Status.FAILED.equals(result.getStatus())) {
//
//        }
//        if (Status.SKIPPED.equals(result.getStatus())) {
//
//        }
    }

    // Step started event
    private void stepStarted(TestStepStarted event) {
//        String stepName = "";
//        String keyword = "";
//
//        if (event.getTestStep() instanceof PickleStepTestStep) {
//            PickleStepTestStep steps = (PickleStepTestStep) event.getTestStep();
//            stepName = steps.getStep().getText();
//            keyword = steps.getStep().getKeyword();
//        } else {
//            HookTestStep hoo = (HookTestStep) event.getTestStep();
//            stepName = hoo.getHookType().name();
//        }
    }

    // This is triggered when test Step is finished
    private void stepFinished(TestStepFinished event) {
//        Result result = event.getResult();
//
//        if (Status.PASSED.equals(result.getStatus())) {
//
//        }
//        if (Status.FAILED.equals(result.getStatus())) {
//
//        }
//        if (Status.SKIPPED.equals(result.getStatus())) {
//
//        }
    }

}
