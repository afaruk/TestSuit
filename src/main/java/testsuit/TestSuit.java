package testsuit;

import testsuit.result.Reporter;
import testsuit.result.TestResult;
import testsuit.services.TestSuitManager;

import java.io.IOException;

public class TestSuit {

    public static void main(String[] args) throws IOException {
        var reporter = new Reporter();
        var testSuitManager = new TestSuitManager();
        var result = testSuitManager.runTest("src/main/resources/firstTest.json");
        reporter.printReport(result);
    }

}
