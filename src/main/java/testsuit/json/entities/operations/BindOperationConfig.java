package testsuit.json.entities.operations;

import testsuit.json.entities.OperationConfigObject;
import testsuit.operation.OperationType;

public class BindOperationConfig implements OperationConfigObject {

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public OperationType getOperationName() {
        return OperationType.BIND;
    }
}
