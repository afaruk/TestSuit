package testsuit.common;

import java.util.StringJoiner;

public interface Result {

    void setStartTime();

    void setFinishedTime();

    long getFinishedTime();

    long getStartTime();

    String getName();

    void addReport(StringJoiner joiner);
}
