package testsuit.operations.bind;

import testsuit.scenario.User;
import testsuit.scenario.chain.ScenarioParam;
import testsuit.common.ThreadUtil;
import testsuit.operations.Operation;
import testsuit.operations.OperationType;
import testsuit.scenario.json.UserObject;

import java.util.List;
import java.util.Random;

public class BindOperation implements Operation<BindOperationResult> {

    private List<User> users;

    public BindOperation(List<User> users) {
        this.users = users;
    }

    @Override
    public BindOperationResult execute(ScenarioParam param) {
        var opResult = new BindOperationResult();
        var user = users.get(param.getThreadSeqNum() % users.size());

        opResult.setStartTime();
        bind(user, opResult);

        opResult.setFinishedTime();

        return opResult;
    }

    private void bind(User user, BindOperationResult opResult) {
        System.out.println(user.getName() + " kisisi " + user.getName() + " kullanrak bind oluyor");

        Random random = new Random();
        int randomWithNextInt = random.nextInt(100) * 10;

        ThreadUtil.sleep(randomWithNextInt);

        opResult.setBindedUser(user.getName());
    }

    @Override
    public OperationType getType() {
        return OperationType.BIND;
    }
}
