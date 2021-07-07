package testsuit.operations;

import testsuit.scenario.chain.ScenarioParam;
import testsuit.scenario.chain.ScenarioTestResult;

public interface Operation<T extends OperationResult> {

    T execute(ScenarioParam param);

    OperationType getType();
}
