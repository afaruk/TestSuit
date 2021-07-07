package testsuit.operations.search;

import testsuit.operations.Operation;
import testsuit.operations.OperationFactory;
import testsuit.scenario.json.RunnerConfigObject;

public class SearchOperationFactory implements OperationFactory<SearchOperationConfig> {

    @Override
    public Operation create(SearchOperationConfig configObject, RunnerConfigObject runConfig) {
        return new SearchOperation(configObject.getCn());
    }
}
