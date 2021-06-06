package testsuit.json.entities;

public class RunnerConfig implements JSonObject {

    private int batchCount;
    private int loopCount;
    private int loopDelay;

    public void setLoopCount(int loopCount) {
        this.loopCount = loopCount;
    }

    public void setBatchCount(int batchCount) {
        this.batchCount = batchCount;
    }

    public void setLoopDelay(int loopDelay) {
        this.loopDelay = loopDelay;
    }

    public int getLoopCount() {
        return loopCount;
    }

    public int getBatchCount() {
        return batchCount;
    }

    public int getLoopDelay() {
        return loopDelay;
    }
}
