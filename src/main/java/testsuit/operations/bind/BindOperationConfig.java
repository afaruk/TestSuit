package testsuit.operations.bind;

import testsuit.scenario.json.OperationConfigObject;
import testsuit.operations.OperationType;

import java.util.List;

public class BindOperationConfig implements OperationConfigObject {

    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public OperationType getOperationName() {
        return OperationType.BIND;
    }
}
