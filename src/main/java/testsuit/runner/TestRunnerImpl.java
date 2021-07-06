package testsuit.runner;

import testsuit.common.RunnerConfig;
import testsuit.common.Scenario;
import testsuit.common.ThreadUtil;
import testsuit.result.LoopResult;
import testsuit.result.TestResult;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

public class TestRunnerImpl implements TestRunner {

    @Override
    public TestResult run(Scenario scenario) {
        var testResult = new TestResult(scenario.getName());
        testResult.setStartTime();
        runTest(scenario, testResult);
        testResult.setFinishedTime();
        return testResult;
    }

    private void runTest(Scenario scenario, TestResult testResult) {
        var executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        runTestUntilLoopCount(scenario, testResult, executor);
        ThreadUtil.waitAllThread(executor);
    }

    private void runTestUntilLoopCount(Scenario scenario, TestResult testResult, ThreadPoolExecutor executor) {
        var runnerConfig = scenario.getRunnerConfig();
        IntStream.range(0, runnerConfig.getLoopCount()).forEach(loopIndex -> {
            var loopResult = new LoopResult(loopIndex);
            var loopTestTask = new LoopTestTask(scenario, loopResult);
            executor.execute(loopTestTask);
            testResult.addLoopResult(loopResult);
            ThreadUtil.sleep(runnerConfig.getLoopDelay());
        });
    }

}
