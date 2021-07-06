package testsuit.common;

import testsuit.chain.ScenarioTestResult;
import testsuit.operation.OperationType;
import testsuit.result.operations.OperationResult;

public interface Operation<T extends OperationResult> {

    T execute(ScenarioTestResult result);

    OperationType getType();
}
