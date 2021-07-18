package testsuit.operations;

import testsuit.scenario.chain.ScenarioParam;

public interface Operation<T extends OperationResult> {

    T execute(ScenarioParam param);

    OperationType getType();
}
