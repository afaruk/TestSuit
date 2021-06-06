package testsuit.services;

import testsuit.chain.Chain;
import testsuit.chain.ScenarioChainFactory;
import testsuit.json.JSonFileOperation;
import testsuit.json.entities.ScenarioObject;
import testsuit.result.TestResult;
import testsuit.runner.TestRunner;

import java.io.IOException;

public class TestSuitManager {

    private JSonFileOperation jSonFileOperation;
    private TestRunner testRunner;

    public TestSuitManager() {
        jSonFileOperation = new JSonFileOperation();
        testRunner = new TestRunner();
    }

    public TestResult runTest(String filePathName) throws IOException {
        ScenarioObject jsonObject = createScenaroObject(filePathName);
        Chain chain = ScenarioChainFactory.INSTANCE.create(jsonObject.getSteps());
        return testRunner.run(jsonObject.getRunnerConfig(), chain);
    }

    private ScenarioObject createScenaroObject(String filePathName) throws IOException {
        ScenarioObject jsonObject = jSonFileOperation.createJsonObject(filePathName, ScenarioObject.class);
        jSonFileOperation.printJsonObject(jsonObject);
        return jsonObject;
    }


}
