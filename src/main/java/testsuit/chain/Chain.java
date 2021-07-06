package testsuit.chain;

import testsuit.operation.OperationType;

public interface Chain {

    void execute(ScenarioTestResult result);

    void setNextChain(Chain nextChain);

    OperationType getOperationType();

}
