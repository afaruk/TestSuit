package testsuit;

import testsuit.report.Reporter;
import testsuit.runner.TestResult;
import testsuit.services.TestSuitManager;

import java.io.IOException;
import java.util.ArrayList;

public class TestSuit {

    public static void main(String[] args) {
        var reporter = new Reporter();
        var testSuitManager = new TestSuitManager();
        var scenarioFilePaths = new ArrayList<String>();
//        scenarioFilePaths.add("src/main/resources/BindWithOneUser.json");
//        scenarioFilePaths.add("src/main/resources/BindWithMultiUser.json");
        scenarioFilePaths.add("src/main/resources/BindWithSequencialUsers.json");
        scenarioFilePaths.add("src/main/resources/BindWithRestirictedSequencialUsers.json");
        scenarioFilePaths.stream().forEach(path -> {
            TestResult result;
            try {
                result = testSuitManager.runTest(path);
                reporter.printReport(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
