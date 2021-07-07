package testsuit.operations.search;

import testsuit.scenario.json.OperationConfigObject;
import testsuit.operations.OperationType;

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
