package testsuit.operations;

import testsuit.scenario.json.OperationConfigObject;
import testsuit.scenario.json.RunnerConfigObject;

public interface OperationFactory<T extends OperationConfigObject> {

    Operation create(T configObject, RunnerConfigObject runConfig);
}
