package testsuit.operations.modify;

import testsuit.operations.Operation;
import testsuit.operations.OperationFactory;
import testsuit.scenario.Configs;
import testsuit.scenario.ServerConfig;
import testsuit.scenario.User;

public class ModifyOperationFactory implements OperationFactory<ModifyOperationConfig> {

    @Override
    public Operation create(ModifyOperationConfig operationObject, Configs configs) {

        if (operationObject.getModificationType().equals("ADD")) {
            User authorizedUser = configs.getAuthorizedUser();
            ServerConfig serverConfig = configs.getServerConfig();
            return new AddEntryOperation(serverConfig, authorizedUser);
        }

        return null;
    }
}
