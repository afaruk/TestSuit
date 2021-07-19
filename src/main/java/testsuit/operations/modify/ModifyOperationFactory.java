package testsuit.operations.modify;

import testsuit.operations.Operation;
import testsuit.operations.OperationFactory;
import testsuit.scenario.Configs;
import testsuit.scenario.ModifyEntry;

import java.util.ArrayList;

public class ModifyOperationFactory implements OperationFactory<ModifyOperationConfig> {

    @Override
    public Operation create(ModifyOperationConfig operationObject, Configs configs) {

        if (operationObject.getModificationType().equals("ADD")) {
            return createAddEntryOperation(operationObject);
        }

        return null;
    }

    private AddEntryOperation createAddEntryOperation(ModifyOperationConfig operationObject) {
        var entries = new ArrayList<ModifyEntry>();
        entries.add(operationObject);
        return new AddEntryOperation(entries);
    }
}
