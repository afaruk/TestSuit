package testsuit.scenario.chain;

import testsuit.scenario.json.OperationConfigObject;
import testsuit.operations.Operation;
import testsuit.operations.OperationFactoryStrategy;
import testsuit.scenario.json.RunnerConfigObject;

import java.util.List;

public enum ScenarioChainFactory {

    INSTANCE;

    public Chain create(List<OperationConfigObject> steps, RunnerConfigObject runConfig) {
        System.out.println("Senaryo zinciri oluşturma işlemi başlatıldı.");
        ChainBuilder chainBuilder = new ChainBuilder();
        steps.stream().forEach(operationConfigObject -> {
            Chain chain = createChain(operationConfigObject, runConfig);
            chainBuilder.addChain(chain);
            System.out.println(chain.getOperationType() + " operasyonu zincire eklendi");
        });

        return chainBuilder.build();
    }

    private Chain createChain(OperationConfigObject operationConfigObject, RunnerConfigObject runConfig) {
        Operation operation = OperationFactoryStrategy.INSTANCE.create(operationConfigObject, runConfig);
        return new OperationChain(operation);
    }
}
