package testsuit.result.operations;

import testsuit.operation.OperationType;
import testsuit.result.Result;

public interface OperationResult extends Result {

    OperationType getOperationType();
}
