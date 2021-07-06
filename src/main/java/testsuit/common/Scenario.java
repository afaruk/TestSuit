package testsuit.common;

import testsuit.chain.Chain;

public interface Scenario {

    String getName();

    RunnerConfig getRunnerConfig();

    Chain getScenarioChain();
}
