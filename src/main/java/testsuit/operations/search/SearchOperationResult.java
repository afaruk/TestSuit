package testsuit.operations.search;

import testsuit.operations.OperationType;
import testsuit.operations.AbstractOperationResult;

import java.util.StringJoiner;

public class SearchOperationResult extends AbstractOperationResult {

    public SearchOperationResult() {
        super(OperationType.SEARCH);
    }

    @Override
    protected void addOperationReport(StringJoiner joiner) {

    }
}
