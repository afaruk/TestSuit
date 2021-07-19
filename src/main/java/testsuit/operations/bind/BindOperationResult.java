package testsuit.operations.bind;

import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.ResultCode;
import testsuit.operations.OperationType;
import testsuit.operations.AbstractOperationResult;
import testsuit.scenario.User;

import java.util.StringJoiner;

public class BindOperationResult extends AbstractOperationResult<BindResult> {

    private LDAPConnection connection;
    private User user;

    public BindOperationResult(int sequenceNum) {
        super(OperationType.BIND, sequenceNum);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setConnection(LDAPConnection connection) {
        this.connection = connection;
    }

    public LDAPConnection getConnection() {
        return connection;
    }

    @Override
    protected void addOperationReport(StringJoiner joiner) {
        joiner.add(user.toString());
        if (getResult().getResultCode().equals(ResultCode.SUCCESS)) {
            joiner.add("Status: SUCCESS");
        } else {
            joiner.add("Status: FAILED");
            joiner.add("Error Code:" + getResult().getResultCode());
        }
    }
}
