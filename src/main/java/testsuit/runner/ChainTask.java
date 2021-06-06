package testsuit.runner;

import testsuit.chain.Chain;
import testsuit.chain.ChainResult;

public class ChainTask implements Runnable {

    private Chain chain;
    private ChainResult chainResult;

    ChainTask(Chain chain, ChainResult chainResult) {
        this.chain = chain;
        this.chainResult = chainResult;
    }

    public void run() {
        chainResult.setStartTime();
        chain.execute(chainResult);
        chainResult.setFinishedTime();
    }
}
