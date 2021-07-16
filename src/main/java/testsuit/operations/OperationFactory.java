package testsuit.operations;

import testsuit.scenario.Configs;
import testsuit.scenario.json.OperationConfigObject;
import testsuit.scenario.json.RunnerConfigObject;

public interface OperationFactory<T extends OperationConfigObject> {

    Operation create(T operationObject, Configs configs);
}
