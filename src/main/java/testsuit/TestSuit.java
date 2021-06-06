package testsuit;

import testsuit.result.Reporter;
import testsuit.result.TestResult;
import testsuit.services.TestSuitManager;

import java.io.IOException;

public class TestSuit {

    public static void main(String[] args) throws IOException {
        Reporter reporter = new Reporter();
        TestResult result = new TestSuitManager().runTest("src/main/resources/scenario.json");
        reporter.printReport(result);
    }

}
