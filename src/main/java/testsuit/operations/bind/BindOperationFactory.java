package testsuit.operations.bind;

import testsuit.operations.Operation;
import testsuit.operations.OperationFactory;
import testsuit.scenario.Configs;
import testsuit.scenario.User;
import testsuit.scenario.json.RunnerConfigObject;
import testsuit.scenario.json.UserObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BindOperationFactory implements OperationFactory<BindOperationConfig> {

    @Override
    public Operation create(BindOperationConfig operationObject, Configs configs) {

        List<User> users = operationObject.getUsers();
        if (users.size() == 1) {
            var user = users.get(0);
            if (user.getName().contains("#")) {
                users =  createUserListAccordingToThreadNumber(user, configs.getRunnerConfig().getThreadCountForSteps());
            }
        }
        return new BindOperation(users);
    }

    private List<User> createUserListAccordingToThreadNumber(User user, int threadCount) {
        var users = new ArrayList<User>();
        String name = user.getName();
        String password = user.getPassword();
        IntStream.range(0, threadCount).forEach(index -> {
            UserObject newUser = new UserObject();
            newUser.setName(name.replace("#", Integer.toString(index)));
            newUser.setPassword(password);
            users.add(newUser);
        });

        return users;
    }
}
