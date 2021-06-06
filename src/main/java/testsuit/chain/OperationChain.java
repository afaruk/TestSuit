package testsuit.chain;

import testsuit.operation.Operation;
import testsuit.operation.OperationType;
import testsuit.result.operations.OperationResult;

public class OperationChain implements Chain {

    private Operation operation;

    private Chain nextChain;

    public OperationChain(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void execute(ChainResult result) {
        OperationResult opResult = operation.execute(result);
        result.addOperationResult(opResult);
        if (nextChain != null) {
            nextChain.execute(result);
        }
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public OperationType getOperationType() {
        return operation.getType();
    }
}
