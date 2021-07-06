package testsuit.runner;

import testsuit.chain.Chain;
import testsuit.common.RunnerConfig;
import testsuit.common.Scenario;
import testsuit.result.TestResult;

public interface TestRunner {

    TestResult run(Scenario scenario);
}
