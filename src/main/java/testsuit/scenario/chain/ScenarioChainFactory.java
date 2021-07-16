package testsuit.scenario.chain;

import testsuit.scenario.Configs;
import testsuit.scenario.json.OperationConfigObject;
import testsuit.operations.Operation;
import testsuit.operations.OperationFactoryStrategy;
import testsuit.scenario.json.RunnerConfigObject;

import java.util.List;

public enum ScenarioChainFactory {

    INSTANCE;

    public Chain create(List<OperationConfigObject> steps, Configs configs) {
        System.out.println("Senaryo zinciri oluşturma işlemi başlatıldı.");
        ChainBuilder chainBuilder = new ChainBuilder();
        steps.stream().forEach(operationObject -> {
            Chain chain = createChain(operationObject, configs);
            chainBuilder.addChain(chain);
            System.out.println(chain.getOperationType() + " operasyonu zincire eklendi");
        });

        return chainBuilder.build();
    }

    private Chain createChain(OperationConfigObject operationObject, Configs configs) {
        Operation operation = OperationFactoryStrategy.INSTANCE.create(operationObject, configs);
        return new OperationChain(operation);
    }
}
