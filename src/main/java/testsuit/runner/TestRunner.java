package testsuit.runner;

import testsuit.scenario.Scenario;

public interface TestRunner {

    TestResult run(Scenario scenario);
}
