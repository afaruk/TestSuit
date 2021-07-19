package testsuit.operations.bind;

import testsuit.operations.Operation;
import testsuit.operations.OperationFactory;
import testsuit.scenario.Configs;
import testsuit.scenario.User;
import testsuit.scenario.json.RunnerConfigObject;
import testsuit.scenario.json.UserObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BindOperationFactory implements OperationFactory<BindOperationConfig> {

    /* Pattern is used user name suffix boundary. Exp: #[5,10] */
    private Pattern pattern = Pattern.compile("#\\[(.*?)\\]");

    @Override
    public Operation create(BindOperationConfig operationObject, Configs configs) {
        List<User> users = getUsers(operationObject, configs);
        return new BindOperation(users, configs.getServerConfig());
    }

    private List<User> getUsers(BindOperationConfig operationObject, Configs configs) {
        List<User> users = operationObject.getUsers();
        if (users.isEmpty()) {
            throw new IllegalArgumentException("At least one user must be exist.");
        }

        if (users.size() > 1) {
            return users;
        }

        User user = users.get(0);
        if (!user.getName().contains("#")) {
            return users;
        }

        return createSequentialUserList(user, configs.getRunnerConfig().getThreadCountForSteps());
    }

    private List<User> createSequentialUserList(User user, int threadCount) {
        Matcher matcher = pattern.matcher(user.getName());
        if (matcher.find()) {
            return createRestrictedSequentialUserList(user, matcher);
        } else {
            return createSequentialUserListAccordingToThreadCount(user, threadCount);
        }
    }

    private List<User> createSequentialUserListAccordingToThreadCount(User user, int threadCount) {
        return reproduceUsers(user, 0, threadCount, "#");
    }

    private List<User> createRestrictedSequentialUserList(User user, Matcher matcher) {
        String group = matcher.group(1);
        String[] split = group.split(",");
        var startInt = Integer.parseInt(split[0]);
        var endInt = Integer.parseInt(split[1]);
        return reproduceUsers(user, startInt, endInt, matcher.group());
    }

    private List<User> reproduceUsers(User origUser, int startIndex, int endIndex, String beReplacedStr) {
        var users = new ArrayList<User>();
        IntStream.range(startIndex, endIndex).forEach(index -> {
            UserObject newUser = new UserObject();
            newUser.setName(origUser.getName().replace(beReplacedStr, Integer.toString(index)));
            newUser.setPassword(origUser.getPassword());
            users.add(newUser);
        });
        return users;
    }
}
