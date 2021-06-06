package testsuit.operation;

import testsuit.json.entities.OperationConfigObject;

public interface OperationFactory<T extends OperationConfigObject> {

    Operation create(T configObject);
}
