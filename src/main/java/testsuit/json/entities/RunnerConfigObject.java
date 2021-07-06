package testsuit.json.entities;

import testsuit.common.RunnerConfig;

public class RunnerConfigObject implements JSonObject, RunnerConfig {

    private int threadCountForSteps;
    private int loopCount;
    private int loopDelay;

    public void setLoopCount(int loopCount) {
        this.loopCount = loopCount;
    }

    public void setThreadCountForSteps(int threadCountForSteps) {
        this.threadCountForSteps = threadCountForSteps;
    }

    public void setLoopDelay(int loopDelay) {
        this.loopDelay = loopDelay;
    }

    @Override
    public int getLoopCount() {
        return loopCount;
    }

    @Override
    public int getThreadCountForSteps() {
        return threadCountForSteps;
    }

    @Override
    public int getLoopDelay() {
        return loopDelay;
    }
}
