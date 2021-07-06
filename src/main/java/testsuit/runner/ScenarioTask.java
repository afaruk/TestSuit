package testsuit.runner;

import testsuit.chain.Chain;
import testsuit.chain.ScenarioTestResult;

public class ScenarioTask implements Runnable {

    private Chain scenarioChain;
    private ScenarioTestResult scenarioTestResult;

    ScenarioTask(Chain scenarioChain, ScenarioTestResult scenarioTestResult) {
        this.scenarioChain = scenarioChain;
        this.scenarioTestResult = scenarioTestResult;
    }

    public void run() {
        scenarioTestResult.setStartTime();
        scenarioChain.execute(scenarioTestResult);
        scenarioTestResult.setFinishedTime();
    }
}
