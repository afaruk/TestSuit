package testsuit.json.entities.operations;

import testsuit.json.entities.OperationConfigObject;
import testsuit.operation.OperationType;

public class SearchOperationConfig implements OperationConfigObject {

    private String cn;

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    @Override
    public OperationType getOperationName() {
        return OperationType.SEARCH;
    }
}
