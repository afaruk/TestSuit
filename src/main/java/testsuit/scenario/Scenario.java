package testsuit.scenario;

import testsuit.scenario.chain.Chain;

public interface Scenario {

    String getName();

    Chain getScenarioChain();

    Configs getConfigs();
}
