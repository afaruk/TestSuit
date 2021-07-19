package testsuit.operations.search;

import testsuit.common.ThreadUtil;
import testsuit.operations.Operation;
import testsuit.operations.OperationType;
import testsuit.operations.bind.BindOperationResult;
import testsuit.scenario.chain.ScenarioParam;
import testsuit.scenario.chain.ScenarioTestResult;

public class SearchOperation implements Operation {

    private String cn;

    public SearchOperation(String cn) {
        this.cn = cn;
    }

    @Override
    public SearchOperationResult execute(ScenarioParam param) {

        var operationResults = param.getScenarioTestResult().getOperationResults(OperationType.BIND);

        SearchOperationResult opResult = new SearchOperationResult(param.getThreadSeqNum());
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
