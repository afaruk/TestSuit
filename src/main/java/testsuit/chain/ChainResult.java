package testsuit.chain;

import testsuit.result.AbstractResult;
import testsuit.result.operations.OperationResult;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ChainResult extends AbstractResult {

    private List<OperationResult> operationResults = new ArrayList<>();

    public ChainResult(int sequenceNum) {
        super("Chain-" + sequenceNum);
    }

    public void addOperationResult(OperationResult opResult) {
        operationResults.add(opResult);
    }

    public List<OperationResult> getOperationResults() {
        return operationResults;
    }

    @Override
    public void addReport(StringJoiner joiner) {
        joiner.add("////////////////////////////////////////////");
        addHeaderInfo(joiner);
        getOperationResults().stream().forEach(operationResult -> {
            operationResult.addReport(joiner);
        });
        joiner.add("/////////////////////////////////////////////");
    }
}
