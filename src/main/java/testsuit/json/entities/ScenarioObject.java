package testsuit.json.entities;

import java.io.Serializable;
import java.util.List;


public class ScenarioObject implements Serializable {

    private String name;
    private RunnerConfig runnerConfig;
    private List<OperationConfigObject> steps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSteps(List<OperationConfigObject> steps) {
        this.steps = steps;
    }

    public List<OperationConfigObject> getSteps() {
        return steps;
    }

    public void setRunnerConfig(RunnerConfig runnerConfig) {
        this.runnerConfig = runnerConfig;
    }

    public RunnerConfig getRunnerConfig() {
        return runnerConfig;
    }
}
