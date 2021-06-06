package testsuit.result.operations;

import testsuit.operation.OperationType;
import testsuit.result.AbstractResult;

import java.util.StringJoiner;

public abstract class AbstractOperationResult extends AbstractResult implements OperationResult {

    private OperationType operationType;

    public AbstractOperationResult(OperationType operationType) {
        super(operationType.getName());
        this.operationType = operationType;
    }

    @Override
    public OperationType getOperationType() {
        return operationType;
    }

    @Override
    public void addReport(StringJoiner joiner) {
        joiner.add("==========================================");
        addHeaderInfo(joiner);
        joiner.add("==========================================");
    }

}
