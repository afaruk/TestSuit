package testsuit.operation.search;

import testsuit.chain.ScenarioTestResult;
import testsuit.common.ThreadUtil;
import testsuit.common.Operation;
import testsuit.operation.OperationType;
import testsuit.result.operations.SearchOperationResult;

public class SearchOperation implements Operation {

    private String cn;

    public SearchOperation(String cn) {
        this.cn = cn;
    }

    @Override
    public SearchOperationResult execute(ScenarioTestResult result) {
        SearchOperationResult opResult = new SearchOperationResult();
        opResult.setStartTime();

        System.out.println("Aranacak cn:" + cn);
        ThreadUtil.sleep(100);

        opResult.setFinishedTime();

        return opResult;
    }

    @Override
    public OperationType getType() {
        return OperationType.SEARCH;
    }
}
