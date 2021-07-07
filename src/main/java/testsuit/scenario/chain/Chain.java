package testsuit.scenario.chain;

import testsuit.operations.OperationType;

public interface Chain {

    void execute(ScenarioParam param);

    void setNextChain(Chain nextChain);

    OperationType getOperationType();

}
