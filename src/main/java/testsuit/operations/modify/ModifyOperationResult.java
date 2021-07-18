package testsuit.operations.modify;

import testsuit.operations.AbstractOperationResult;
import testsuit.operations.OperationType;

import java.util.StringJoiner;

public class ModifyOperationResult extends AbstractOperationResult {

    public ModifyOperationResult() {
        super(OperationType.MODIFY);
    }

    @Override
    protected void addOperationReport(StringJoiner joiner) {
        
    }
}
