package testsuit.services;

import testsuit.scenario.Scenario;
import testsuit.scenario.services.JSonFileOperation;
import testsuit.scenario.json.ScenarioObject;
import testsuit.runner.TestResult;
import testsuit.runner.TestRunner;
import testsuit.runner.services.TestRunnerImpl;

import java.io.IOException;

public class TestSuitManager {

    private JSonFileOperation jSonFileOperation;
    private TestRunner testRunner;

    public TestSuitManager() {
        jSonFileOperation = new JSonFileOperation();
        testRunner = new TestRunnerImpl();
    }

    public TestResult runTest(String filePathName) throws IOException {
        Scenario scenario = createScenario(filePathName);
        return testRunner.run(scenario);
    }

    private Scenario createScenario(String filePathName) throws IOException {
        var jsonObject = jSonFileOperation.createJsonObject(filePathName, ScenarioObject.class);
        jSonFileOperation.printJsonObject(jsonObject);
        return jsonObject;
    }

}
