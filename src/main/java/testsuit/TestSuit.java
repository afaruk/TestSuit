package testsuit;

import testsuit.report.Reporter;
import testsuit.services.TestSuitManager;

import java.io.IOException;

public class TestSuit {

    public static void main(String[] args) throws IOException {
        var reporter = new Reporter();
        var testSuitManager = new TestSuitManager();
        var result = testSuitManager.runTest("src/main/resources/AddRemoveEntryTest.json");
        reporter.printReport(result);
    }

}
