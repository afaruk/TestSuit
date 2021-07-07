package testsuit.runner;

import testsuit.scenario.chain.ScenarioTestResult;
import testsuit.common.AbstractResult;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class LoopResult extends AbstractResult {

    private List<ScenarioTestResult> scenarioTestResults = new ArrayList<>();

    public LoopResult(int loopIndex) {
        super((loopIndex + 1) + ". Loop");
    }

    public void addScenarioTestResult(ScenarioTestResult scenarioTestResult) {
        scenarioTestResults.add(scenarioTestResult);
    }

    public List<ScenarioTestResult> getScenarioTestResults() {
        return scenarioTestResults;
    }

    @Override
    public void addReport(StringJoiner joiner) {
        joiner.add("###########################################");
        addHeaderInfo(joiner);
        getScenarioTestResults().stream().forEach(chainResult -> {
            chainResult.addReport(joiner);
        });
    }
}
