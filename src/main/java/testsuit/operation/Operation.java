package testsuit.operation;

import testsuit.chain.ChainResult;
import testsuit.result.operations.OperationResult;

public interface Operation<T extends OperationResult> {

    T execute(ChainResult result);

    OperationType getType();
}
