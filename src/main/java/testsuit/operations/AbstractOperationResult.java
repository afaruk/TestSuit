package testsuit.operations;

import testsuit.common.AbstractResult;

import java.util.StringJoiner;

public abstract class AbstractOperationResult<T> extends AbstractResult implements OperationResult {

    private OperationType operationType;
    private T result;

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
        joiner.add(" ");
        addHeaderInfo(joiner);
        addOperationReport(joiner);
    }

    protected abstract void addOperationReport(StringJoiner joiner);

}
