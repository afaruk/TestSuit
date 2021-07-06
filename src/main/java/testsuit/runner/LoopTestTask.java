package testsuit.runner;

import testsuit.chain.Chain;
import testsuit.chain.ScenarioTestResult;
import testsuit.common.Scenario;
import testsuit.common.ThreadUtil;
import testsuit.result.LoopResult;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

public class LoopTestTask implements Runnable {

    private Chain chain;
    private int threadCount;
    private LoopResult loopResult;

    public LoopTestTask(Scenario scenario, LoopResult loopResult) {

        this.chain = scenario.getScenarioChain();
        this.threadCount = scenario.getRunnerConfig().getThreadCountForSteps();
        this.loopResult = loopResult;
    }

    @Override
    public void run() {
        loopResult.setStartTime();
        runLoopTask(chain, loopResult);
        loopResult.setFinishedTime();
    }

    private void runLoopTask(Chain chain, LoopResult loopResult) {
        var executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadCount);
        runScenarioTaskWithSeparateThreads(chain, executor, threadCount, loopResult);
        ThreadUtil.waitAllThread(executor);
    }

    private void runScenarioTaskWithSeparateThreads(Chain chain, ThreadPoolExecutor executor, int threadCount, LoopResult batchResult) {
        IntStream.range(0, threadCount).forEach(threadSeq -> {
            var scenarioTestResult = runTask(chain, executor, threadSeq);
            loopResult.addScenarioTestResult(scenarioTestResult);
        });
    }

    private ScenarioTestResult runTask(Chain chain, ThreadPoolExecutor executor, int threadSeq) {
        var scenarioTestResult = new ScenarioTestResult(threadSeq);
        var task = new ScenarioTask(chain, scenarioTestResult);
        executor.execute(task);
        return scenarioTestResult;
    }
}
