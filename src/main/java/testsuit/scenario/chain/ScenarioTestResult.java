package testsuit.scenario.chain;

import testsuit.common.AbstractResult;
import testsuit.operations.OperationResult;
import testsuit.operations.OperationType;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ScenarioTestResult extends AbstractResult {

    private List<OperationResult> operationResults = new ArrayList<>();
    private int threadSeqNumber;

    public ScenarioTestResult(int threadSeqNumber) {
        super((threadSeqNumber + 1) + ". Thread");
        this.threadSeqNumber = threadSeqNumber;
    }

    public void addOperationResult(OperationResult opResult) {
        operationResults.add(opResult);
    }

    public List<OperationResult> getOperationResults() {
        return operationResults;
    }

    public List<OperationResult> getOperationResults(OperationType requstedOperationType) {
        return operationResults
                .stream()
                .filter(oR -> oR.getOperationType().equals(requstedOperationType))
                .collect(Collectors.toList());
    }

    public int getThreadSeqNumber() {
        return threadSeqNumber;
    }

    @Override
    public void addReport(StringJoiner joiner) {
        joiner.add("////////////////////////////////////////////");
        addHeaderInfo(joiner);
        getOperationResults().stream().forEach(operationResult -> {
            operationResult.addReport(joiner);
        });
    }
}
