package testsuit.runner;

import testsuit.chain.Chain;
import testsuit.chain.ChainResult;
import testsuit.common.ThreadUtil;
import testsuit.result.BatchResult;
import testsuit.result.TestResult;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class BatchTestTask implements Runnable {

    private Chain chain;
    private int threadCount;
    private int batchSequence;
    private TestResult testResult;

    public BatchTestTask(Chain chain, int threadCount, int batchSequence, TestResult testResult) {

        this.chain = chain;
        this.threadCount = threadCount;
        this.batchSequence = batchSequence;
        this.testResult = testResult;
    }

    @Override
    public void run() {
        BatchResult results = runScenario(chain, threadCount, batchSequence);
        testResult.addBatchResult(results);
    }

    private BatchResult runScenario(Chain chain, int batchNumber, int sequenceNum) {
        BatchResult batchResult = new BatchResult(sequenceNum);
        batchResult.setStartTime();
        runBatch(chain, batchNumber, batchResult);
        batchResult.setFinishedTime();

        return batchResult;
    }

    private void runBatch(Chain chain, int parallelThreadCount, BatchResult batchResult) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(parallelThreadCount);
        runChainWithSeparateThreads(chain, parallelThreadCount, batchResult, executor);
        ThreadUtil.waitAllThread(executor);
    }

    private void runChainWithSeparateThreads(Chain chain, int parallelThreadCount, BatchResult batchResult, ThreadPoolExecutor executor) {
        for (int i = 0; i < parallelThreadCount; i++) {
            ChainResult chainResult = new ChainResult(i);
            runTask(chain, executor, chainResult);
            batchResult.addChainResult(chainResult);
        }
    }

    private void runTask(Chain chain, ThreadPoolExecutor executor, ChainResult chainResult) {
        ChainTask task = new ChainTask(chain, chainResult);
        executor.execute(task);
    }
}
