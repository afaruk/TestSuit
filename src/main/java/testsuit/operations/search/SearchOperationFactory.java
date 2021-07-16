package testsuit.operations.search;

import testsuit.operations.Operation;
import testsuit.operations.OperationFactory;
import testsuit.scenario.Configs;
import testsuit.scenario.json.RunnerConfigObject;

public class SearchOperationFactory implements OperationFactory<SearchOperationConfig> {

    @Override
    public Operation create(SearchOperationConfig operationObject, Configs configs) {
        return new SearchOperation(operationObject.getCn());
    }
}
