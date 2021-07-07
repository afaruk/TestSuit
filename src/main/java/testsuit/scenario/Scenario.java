package testsuit.scenario;

import testsuit.scenario.chain.Chain;
import testsuit.scenario.json.RunnerConfig;

public interface Scenario {

    String getName();

    RunnerConfig getRunnerConfig();

    Chain getScenarioChain();
}
