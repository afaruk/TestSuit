package testsuit.scenario.chain;

import testsuit.operations.Operation;
import testsuit.operations.OperationType;
import testsuit.operations.OperationResult;

public class OperationChain implements Chain {

    private Operation operation;

    private Chain nextChain;

    public OperationChain(Operation operation) {
        this.operation = operation;
    }

    @Override
    public void execute(ScenarioParam param) {
        OperationResult opResult = operation.execute(param);
        param.getScenarioTestResult().addOperationResult(opResult);
        if (nextChain != null) {
            nextChain.execute(param);
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
