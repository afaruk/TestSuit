package testsuit.scenario.chain;

public class ScenarioParam {

    private int threadSeqNum;
    private ScenarioTestResult scenarioTestResult;


    public ScenarioParam(int threadSeqNum, ScenarioTestResult scenarioTestResult) {
        this.threadSeqNum = threadSeqNum;
        this.scenarioTestResult = scenarioTestResult;
    }

    public int getThreadSeqNum() {
        return threadSeqNum;
    }

    public ScenarioTestResult getScenarioTestResult() {
        return scenarioTestResult;
    }
}
