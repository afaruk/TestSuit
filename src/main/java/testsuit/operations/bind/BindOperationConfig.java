package testsuit.operations.bind;

import testsuit.scenario.User;
import testsuit.scenario.json.OperationConfigObject;
import testsuit.operations.OperationType;
import testsuit.scenario.json.UserObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BindOperationConfig implements OperationConfigObject {

    private List<UserObject> users;

    public void setUsers(List<UserObject> users) {
        this.users = users;
    }

    public List<User> getUsers() {
       return Collections.unmodifiableList(users);
    }

    @Override
    public OperationType getOperationName() {
        return OperationType.BIND;
    }
}
