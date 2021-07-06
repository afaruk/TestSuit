package testsuit.json.entities;

import testsuit.chain.Chain;
import testsuit.chain.ScenarioChainFactory;
import testsuit.common.RunnerConfig;
import testsuit.common.Scenario;

import java.io.Serializable;
import java.util.List;


public class ScenarioObject implements Scenario, Serializable {

    private String name;
    private RunnerConfigObject runnerConfig;
    private List<OperationConfigObject> steps;

    private Chain scenarioChain;

    public void setName(String name) {
        this.name = name;
    }

    public void setSteps(List<OperationConfigObject> steps) {
        this.steps = steps;
    }

    public void setRunnerConfig(RunnerConfigObject runnerConfig) {
        this.runnerConfig = runnerConfig;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RunnerConfig getRunnerConfig() {
        return runnerConfig;
    }

    @Override
    public Chain getScenarioChain() {
        if (scenarioChain == null) {
          scenarioChain = ScenarioChainFactory.INSTANCE.create(steps);
        }

        return scenarioChain;
    }
}
