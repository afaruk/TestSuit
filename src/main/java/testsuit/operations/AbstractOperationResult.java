package testsuit.operations;

import com.unboundid.ldap.sdk.BindResult;
import testsuit.common.AbstractResult;

import java.util.StringJoiner;

public abstract class AbstractOperationResult<T> extends AbstractResult implements OperationResult {

    private OperationType operationType;
    private int sequenceNum;
    private T result;

    public AbstractOperationResult(OperationType operationType, int sequenceNum) {
        super(operationType.getName());
        this.operationType = operationType;
        this.sequenceNum = sequenceNum;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
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
