package testsuit.result;

import testsuit.common.DateUtil;

import java.util.StringJoiner;

public abstract class AbstractResult implements Result {

    private long startTime;

    private long finishedTime;
    private String name;

    public AbstractResult(String name) {
        this.name = name;
    }

    @Override
    public void setStartTime() {
        this.startTime = DateUtil.getCurrentTime();
    }

    @Override
    public void setFinishedTime() {
        this.finishedTime = DateUtil.getCurrentTime();
    }

    @Override
    public long getFinishedTime() {
        return finishedTime;
    }

    @Override
    public long getStartTime() {
        return startTime;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addHeaderInfo(StringJoiner joiner) {
        joiner.add("----------------"+ getName() +"--------------------");
        joiner.add("Başlama :" + DateUtil.convertToDate(getStartTime()) + " Bitiş: " + DateUtil.convertToDate(getFinishedTime()));
        joiner.add("Harcanan zaman: " + (getFinishedTime() - getStartTime()));
    }
}
