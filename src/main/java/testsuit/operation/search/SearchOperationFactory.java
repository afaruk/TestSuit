package testsuit.operation.search;

import testsuit.json.entities.operations.SearchOperationConfig;
import testsuit.operation.Operation;
import testsuit.operation.OperationFactory;

public class SearchOperationFactory implements OperationFactory<SearchOperationConfig> {

    @Override
    public Operation create(SearchOperationConfig configObject) {
        return new SearchOperation(configObject.getCn());
    }
}
