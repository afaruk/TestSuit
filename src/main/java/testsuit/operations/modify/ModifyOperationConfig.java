package testsuit.operations.modify;

import testsuit.operations.OperationType;
import testsuit.scenario.ModifyEntry;
import testsuit.scenario.json.OperationConfigObject;

import java.util.List;

public class ModifyOperationConfig implements OperationConfigObject, ModifyEntry {

    String modificationType;
    String dn;
    List<String> attributes;

    public void setModificationType(String modificationType) {
        this.modificationType = modificationType;
    }

    public void setDn(String dn) {this.dn = dn;}

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public String getModificationType() {
        return modificationType;
    }

    @Override
    public List<String> getAttributes() {
        return attributes;
    }

    @Override
    public String getDn() {
        return dn;
    }

    @Override
    public OperationType getOperationName() {
        return OperationType.MODIFY;
    }

    @Override
    public String toString() {
        return "ModifyOperationConfig{" +
                "modificationType='" + modificationType + '\'' +
                ", dn='" + dn + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
