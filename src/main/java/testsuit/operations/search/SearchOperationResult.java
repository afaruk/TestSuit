package testsuit.operations.search;

import testsuit.operations.OperationType;
import testsuit.operations.AbstractOperationResult;

import java.util.StringJoiner;

public class SearchOperationResult extends AbstractOperationResult {

    public SearchOperationResult(int sequenceNum) {
        super(OperationType.SEARCH, sequenceNum);
    }

    @Override
    protected void addOperationReport(StringJoiner joiner) {

    }
}
