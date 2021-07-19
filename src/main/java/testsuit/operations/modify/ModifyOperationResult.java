package testsuit.operations.modify;

import com.unboundid.ldap.sdk.LDAPResult;
import com.unboundid.ldap.sdk.ResultCode;
import testsuit.operations.AbstractOperationResult;
import testsuit.operations.OperationType;
import testsuit.scenario.ModifyEntry;

import java.util.StringJoiner;

public class ModifyOperationResult extends AbstractOperationResult<LDAPResult> {

    private ModifyEntry modifyEntry;

    public ModifyOperationResult(int sequenceNum) {
        super(OperationType.MODIFY, sequenceNum);
    }

    @Override
    protected void addOperationReport(StringJoiner joiner) {
        joiner.add(modifyEntry.toString());
        if (getResult().getResultCode().equals(ResultCode.SUCCESS)) {
            joiner.add("Status: SUCCESS");
        } else {
            joiner.add("Status: FAILED");
            joiner.add("Error Code:" + getResult().getResultCode());
        }
    }

    public void setEntry(ModifyEntry modifyEntry) {
        this.modifyEntry = modifyEntry;
    }
}
