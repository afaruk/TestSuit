package testsuit.result;

import java.util.StringJoiner;

public class Reporter {


    public void printReport(TestResult result) {
        StringJoiner joiner = new StringJoiner("\n", "\n", "");
        result.addReport(joiner);
        System.out.println(joiner.toString());
    }

}
