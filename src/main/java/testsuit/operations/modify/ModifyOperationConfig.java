package testsuit.operations.modify;

import testsuit.operations.OperationType;
import testsuit.scenario.json.OperationConfigObject;

import java.util.List;

public class ModifyOperationConfig implements OperationConfigObject {

    String modificationType;
    String dn;
    List<String> attributes;

    public void setModificationType(String modificationType) {
        this.modificationType = modificationType;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public String getModificationType() {
        return modificationType;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public String getDn() {
        return dn;
    }

    @Override
    public OperationType getOperationName() {
        return OperationType.MODIFY;
    }
}
