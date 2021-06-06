package testsuit.runner;

import testsuit.chain.Chain;
import testsuit.common.ThreadUtil;
import testsuit.json.entities.RunnerConfig;
import testsuit.result.BatchResult;
import testsuit.result.TestResult;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestRunner {

    public TestResult run(RunnerConfig runnerConfig, Chain chain) {

        TestResult testResult = new TestResult();
        testResult.setStartTime();

        runTest(runnerConfig, chain, testResult);

        testResult.setFinishedTime();
        return testResult;
    }

    private void runTest(RunnerConfig runnerConfig, Chain chain, TestResult testResult) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        runTestUntilLoopCount(runnerConfig, chain, testResult, executor);

        ThreadUtil.waitAllThread(executor);
    }

    private void runTestUntilLoopCount(RunnerConfig runnerConfig, Chain chain, TestResult testResult, ThreadPoolExecutor executor) {
        for (int i = 0; i < runnerConfig.getLoopCount(); i++) {
            BatchTestTask batchTestTask = new BatchTestTask(chain, runnerConfig.getBatchCount(), i, testResult);
            executor.execute(batchTestTask);
            ThreadUtil.sleep(runnerConfig.getLoopDelay());
        }
    }

}
