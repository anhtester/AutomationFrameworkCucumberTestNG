package com.anhtester.hooks;

import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

public class CucumberListener implements EventListener {

    //Khai báo các biến để thống kê tổng số test cases sau khi kết thúc test
    public static int count_totalTCs;
    public static int count_passedTCs;
    public static int count_skippedTCs;
    public static int count_failedTCs;
    
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

    /*
     * Khai báo các hàm đã set events bên trên để lắng nghe từng event
     */

    // Here we create the reporter. Execute before run feature file
    private void runStarted(TestRunStarted event) {

    }

    // runFinished event is triggered when all feature file executions are completed
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

    private void ScenarioStarted(TestCaseStarted event) {
        String featureName = event.getTestCase().getUri().toString();
        System.out.println("Feature Name: " + featureName);

        count_totalTCs = count_totalTCs + 1;
    }

    private void ScenarioFinished(TestCaseFinished event) {
        String featureName = event.getTestCase().getUri().toString();

        //Tại đây thì chúng ta thống kê các Scenario. Vì trong Cucumber thì một test cases là một Scenario
        if (event.getResult().getStatus().toString().equals("PASSED")) {
            count_passedTCs = count_passedTCs + 1;
        }
        if (event.getResult().getStatus().toString().equals("FAILED")) {
            count_failedTCs = count_failedTCs + 1;
        }
        if (event.getResult().getStatus().toString().equals("SKIPPED")) {
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
        //Các bạn có thể screenshot hay như thế nào đó tuỳ ý cho mỗi step với trạng thái tương ứng
        if (event.getResult().getStatus().toString().equals("PASSED")) {

        }
        if (event.getResult().getStatus().toString().equals("FAILED")) {

        }
        if (event.getResult().getStatus().toString().equals("SKIPPED")) {

        }
    }

}
