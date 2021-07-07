package testsuit.operations;

import testsuit.scenario.json.OperationConfigObject;
import testsuit.operations.bind.BindOperationFactory;
import testsuit.operations.search.SearchOperationFactory;
import testsuit.scenario.json.RunnerConfigObject;

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

    public Operation create(OperationConfigObject configObject, RunnerConfigObject runConfig) {
        return operationFactories.get(configObject.getOperationName()).create(configObject, runConfig);
    }
}
