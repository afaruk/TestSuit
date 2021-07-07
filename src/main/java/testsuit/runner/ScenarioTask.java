package testsuit.runner;

import testsuit.scenario.chain.Chain;
import testsuit.scenario.chain.ScenarioParam;
import testsuit.scenario.chain.ScenarioTestResult;

public class ScenarioTask implements Runnable {

    private Chain scenarioChain;
    private ScenarioParam scenarioParam;

    ScenarioTask(Chain scenarioChain, ScenarioParam scenarioParam) {
        this.scenarioChain = scenarioChain;
        this.scenarioParam = scenarioParam;
    }

    public void run() {
        var scenarioTestResult = scenarioParam.getScenarioTestResult();
        scenarioTestResult.setStartTime();
        scenarioChain.execute(scenarioParam);
        scenarioTestResult.setFinishedTime();
    }
}
