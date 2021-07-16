package testsuit.scenario.json;

import netscape.javascript.JSObject;
import testsuit.scenario.Configs;
import testsuit.scenario.RunnerConfig;
import testsuit.scenario.ServerConfig;
import testsuit.scenario.User;

public class ConfigObjects implements JSonObject, Configs {

    private RunnerConfigObject runnerConfig;
    private ServerConfigObject serverConfig;
    private AuthorizedUserObject authorizedUser;

    public void setRunnerConfig(RunnerConfigObject runnerConfig) {
        this.runnerConfig = runnerConfig;
    }

    public void setServerConfig(ServerConfigObject serverConfig) {
        this.serverConfig = serverConfig;
    }

    public void setAuthorizedUser(AuthorizedUserObject authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    @Override
    public RunnerConfig getRunnerConfig() {
        return runnerConfig;
    }

    @Override
    public ServerConfig getServerConfig() {
        return serverConfig;
    }

    @Override
    public User getAuthorizedUser() {
        return authorizedUser;
    }
}
