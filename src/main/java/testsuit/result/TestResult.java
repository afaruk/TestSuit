package testsuit.result;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TestResult extends AbstractResult {

    private List<BatchResult> batchResults = new ArrayList<>();

    public TestResult() {
        super("Test");
    }

    public void addBatchResult(BatchResult batchResult) {
        batchResults.add(batchResult);
    }

    public List<BatchResult> getBatchResults() {
        return batchResults;
    }

    @Override
    public void addReport(StringJoiner joiner) {
        joiner.add("----------------------------------------------------------");
        addHeaderInfo(joiner);
        getBatchResults().stream().forEach(batchResult -> {
            batchResult.addReport(joiner);
        });
        joiner.add("----------------------------------------------------------");
    }
}
