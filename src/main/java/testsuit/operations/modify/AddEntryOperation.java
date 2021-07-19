package testsuit.operations.modify;

import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPResult;
import testsuit.operations.Operation;
import testsuit.operations.OperationResult;
import testsuit.operations.OperationType;
import testsuit.operations.bind.BindOperationResult;
import testsuit.scenario.ModifyEntry;
import testsuit.scenario.chain.ScenarioParam;

import java.util.List;

public class AddEntryOperation implements Operation<ModifyOperationResult> {

    private List<ModifyEntry> entries;

    AddEntryOperation(List<ModifyEntry> entries) {
        this.entries = entries;
    }

    @Override
    public ModifyOperationResult execute(ScenarioParam param) {

        var opResult = new ModifyOperationResult(param.getThreadSeqNum());
        opResult.setStartTime();
        addEntry(param, opResult);
        opResult.setFinishedTime();

        return opResult;
    }

    private void addEntry(ScenarioParam param, ModifyOperationResult opResult) {
        LDAPResult result;
        try {
            LDAPConnection connection = getBindUserConnection(param);
            ModifyEntry modifyEntry = selectEntry(param);
            opResult.setEntry(modifyEntry);
            Entry entry = createEntry(modifyEntry);
            result = connection.add(entry);
        } catch (LDAPException e) {
            result = new LDAPResult(0, e.getResultCode());
        }

        opResult.setResult(result);
    }

    private Entry createEntry(ModifyEntry modifyEntry) {
        Entry entry = new Entry(modifyEntry.getDn());
        modifyEntry.getAttributes().stream().forEach(attr -> {
            String[] split = attr.replaceAll(" ", "").split(":");
            entry.addAttribute(split[0], split[1]);
        });
        return entry;
    }

    private ModifyEntry selectEntry(ScenarioParam param) {
        return entries.get(param.getThreadSeqNum() % entries.size());
    }

    private LDAPConnection getBindUserConnection(ScenarioParam param) {
        List<OperationResult> bindResults = param.getScenarioTestResult().getOperationResults(OperationType.BIND);
        if (bindResults.isEmpty()) {
            return null;
        }

        var bindUserResult = bindResults.get(param.getThreadSeqNum() % entries.size());
        return ((BindOperationResult) bindUserResult).getConnection();
    }

    @Override
    public OperationType getType() {
        return OperationType.MODIFY;
    }
}
