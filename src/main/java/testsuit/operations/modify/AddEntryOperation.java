package testsuit.operations.modify;

import com.unboundid.ldap.sdk.LDAPConnection;
import testsuit.operations.Operation;
import testsuit.operations.OperationType;
import testsuit.scenario.ServerConfig;
import testsuit.scenario.User;
import testsuit.scenario.chain.ScenarioParam;

public class AddEntryOperation implements Operation<ModifyOperationResult> {

    private ServerConfig serverConfig;
    private User authorizedUser;

    public AddEntryOperation(ServerConfig serverConfig, User authorizedUser) {
        this.serverConfig = serverConfig;
        this.authorizedUser = authorizedUser;
    }

    @Override
    public ModifyOperationResult execute(ScenarioParam param) {

//        bindUser();
//        addEntry();
//        unbindUser();

        return new ModifyOperationResult();
    }


    @Override
    public OperationType getType() {
        return null;
    }
}
