package testsuit.operation.bind;

import testsuit.chain.ChainResult;
import testsuit.common.ThreadUtil;
import testsuit.operation.Operation;
import testsuit.operation.OperationType;
import testsuit.result.operations.BindOperationResult;

import java.util.Random;

public class BindOperation implements Operation<BindOperationResult> {

    private String name;
    private String password;

    public BindOperation(String name, String password) {

        this.name = name;
        this.password = password;
    }

    @Override
    public BindOperationResult execute(ChainResult result) {
        BindOperationResult opResult = new BindOperationResult();

        opResult.setStartTime();

        System.out.println(name + " kisisi " + password + " kullanrak bind oluyor");

        Random random = new Random();
        int randomWithNextInt = random.nextInt(100) * 10;

        ThreadUtil.sleep(randomWithNextInt);
        opResult.setFinishedTime();

        return opResult;
    }

    @Override
    public OperationType getType() {
        return OperationType.BIND;
    }
}
