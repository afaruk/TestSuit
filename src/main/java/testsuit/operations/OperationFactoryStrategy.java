package testsuit.operations;

import testsuit.operations.modify.ModifyOperationFactory;
import testsuit.scenario.Configs;
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
        operationFactories.put(OperationType.MODIFY, new ModifyOperationFactory());
    }

    public Operation create(OperationConfigObject operationObject, Configs configs) {
        return operationFactories.get(operationObject.getOperationName()).create(operationObject, configs);
    }
}
