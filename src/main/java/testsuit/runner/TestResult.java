package testsuit.runner;

import testsuit.common.AbstractResult;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class TestResult extends AbstractResult {

    private List<LoopResult> loopResults = new ArrayList<>();

    public TestResult(String name) {
        super(name);
    }

    public void addLoopResult(LoopResult loopResult) {
        loopResults.add(loopResult);
    }

    public List<LoopResult> getLoopResults() {
        return loopResults;
    }

    @Override
    public void addReport(StringJoiner joiner) {
        addHeaderInfo(joiner);
        getLoopResults().stream().forEach(batchResult -> {
            batchResult.addReport(joiner);
        });
    }
}
