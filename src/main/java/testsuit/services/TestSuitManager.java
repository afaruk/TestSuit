package testsuit.services;

import testsuit.chain.Chain;
import testsuit.chain.ScenarioChainFactory;
import testsuit.common.Scenario;
import testsuit.json.JSonFileOperation;
import testsuit.json.entities.ScenarioObject;
import testsuit.result.TestResult;
import testsuit.runner.TestRunnerImpl;

import java.io.IOException;

public class TestSuitManager {

    private JSonFileOperation jSonFileOperation;
    private TestRunnerImpl testRunner;

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
