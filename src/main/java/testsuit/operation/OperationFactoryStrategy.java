package testsuit.operation;

import testsuit.json.entities.OperationConfigObject;
import testsuit.operation.bind.BindOperationFactory;
import testsuit.operation.search.SearchOperationFactory;

import java.util.EnumMap;
import java.util.Map;

public enum OperationFactoryStrategy {

    INSTANCE;

    private Map<OperationType, OperationFactory> operationFactories;

    OperationFactoryStrategy() {
        operationFactories = new EnumMap<>(OperationType.class);
        operationFactories.put(OperationType.BIND, new BindOperationFactory());
        operationFactories.put(OperationType.SEARCH, new SearchOperationFactory());
    }

    public Operation create(OperationConfigObject configObject) {
        return operationFactories.get(configObject.getOperationName()).create(configObject);
    }
}
