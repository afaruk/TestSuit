package testsuit.operations.bind;

import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import testsuit.scenario.ServerConfig;
import testsuit.scenario.User;
import testsuit.scenario.chain.ScenarioParam;
import testsuit.operations.Operation;
import testsuit.operations.OperationType;

import java.util.List;

public class BindOperation implements Operation<BindOperationResult> {

    private List<User> users;
    private ServerConfig serverConfig;

    public BindOperation(List<User> users, ServerConfig serverConfig) {
        this.users = users;
        this.serverConfig = serverConfig;
    }

    @Override
    public BindOperationResult execute(ScenarioParam param) {
        var opResult = new BindOperationResult(param.getThreadSeqNum());
        User user = selectUser(param);
        opResult.setUser(user);

        opResult.setStartTime();
        bind(user.getName(), user.getPassword(), opResult);
        opResult.setFinishedTime();

        return opResult;
    }

    private void bind(String name, String password, BindOperationResult opResult) {

        BindResult result;
        LDAPConnection connection;
        try {
            connection = new LDAPConnection(serverConfig.getHost(), serverConfig.getPort());
            result = connection.bind(name, password);
        } catch (LDAPException e) {
            result = new BindResult(e);
            connection = null;
        }

        opResult.setConnection(connection);
        opResult.setResult(result);
    }


    private User selectUser(ScenarioParam param) {
        return users.get(param.getThreadSeqNum() % users.size());
    }

    @Override
    public OperationType getType() {
        return OperationType.BIND;
    }
}
