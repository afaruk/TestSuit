package testsuit.operation.bind;

import testsuit.json.entities.operations.BindOperationConfig;
import testsuit.common.Operation;
import testsuit.operation.OperationFactory;

public class BindOperationFactory implements OperationFactory<BindOperationConfig> {

    @Override
    public Operation create(BindOperationConfig configObject) {
        return new BindOperation(configObject.getName(), configObject.getPassword());
    }
}
