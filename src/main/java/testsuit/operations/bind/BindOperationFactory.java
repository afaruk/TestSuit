package testsuit.operations.bind;

import testsuit.operations.Operation;
import testsuit.operations.OperationFactory;
import testsuit.scenario.json.RunnerConfigObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BindOperationFactory implements OperationFactory<BindOperationConfig> {

    @Override
    public Operation create(BindOperationConfig configObject, RunnerConfigObject runConfig) {

        List<User> users = configObject.getUsers();
        if (users.size() == 1) {
            User user = users.get(0);
            if (user.getName().contains("#")) {
                users =  createUserListAccordingToThreadNumber(user, runConfig.getThreadCountForSteps());
            }
        }
        return new BindOperation(users);
    }

    private List<User> createUserListAccordingToThreadNumber(User user, int threadCount) {
        var users = new ArrayList<User>();
        String name = user.getName();
        String password = user.getPassword();
        IntStream.range(0, threadCount).forEach(index -> {
            User newUser = new User();
            newUser.setName(name.replace("#", Integer.toString(index)));
            newUser.setPassword(password);
            users.add(newUser);
        });

        return users;
    }
}
