package testsuit.report;

import testsuit.runner.TestResult;

import java.util.StringJoiner;

public class Reporter {


    public void printReport(TestResult result) {
        StringJoiner joiner = new StringJoiner("\n", "\n", "");
        result.addReport(joiner);
        System.out.println(joiner.toString());
    }

}
