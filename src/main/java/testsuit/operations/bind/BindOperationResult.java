package testsuit.operations.bind;

import testsuit.operations.OperationType;
import testsuit.operations.AbstractOperationResult;

public class BindOperationResult extends AbstractOperationResult {

    private String bindedUser;

    public BindOperationResult() {
        super(OperationType.BIND);
    }


    public String getBindedUser() {
        return bindedUser;
    }

    public void setBindedUser(String bindedUser) {
        this.bindedUser = bindedUser;
    }
}
