package testsuit.chain;

import testsuit.operation.OperationType;

public interface Chain {

    void execute(ChainResult result);

    void setNextChain(Chain nextChain);

    OperationType getOperationType();

}
