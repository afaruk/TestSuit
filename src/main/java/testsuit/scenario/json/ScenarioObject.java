package testsuit.scenario.json;

import testsuit.scenario.*;
import testsuit.scenario.chain.Chain;
import testsuit.scenario.chain.ScenarioChainFactory;

import java.io.Serializable;
import java.util.List;


public class ScenarioObject implements Scenario, Serializable {

    private String name;
    private Configs configs;
    private List<OperationConfigObject> steps;

    private Chain scenarioChain;

    public void setName(String name) {
        this.name = name;
    }

    public void setSteps(List<OperationConfigObject> steps) {
        this.steps = steps;
    }

    public void setConfigs(ConfigObjects configs) {
        this.configs = configs;
    }

    public List<OperationConfigObject> getSteps() {
        return steps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Configs getConfigs() {
        return configs;
    }

    @Override
    public Chain getScenarioChain() {
        if (scenarioChain == null) {
          scenarioChain = ScenarioChainFactory.INSTANCE.create(steps, configs);
        }

        return scenarioChain;
    }
}
