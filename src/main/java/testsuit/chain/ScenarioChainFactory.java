package testsuit.chain;

import testsuit.json.entities.OperationConfigObject;
import testsuit.operation.Operation;
import testsuit.operation.OperationFactoryStrategy;

import java.util.List;

public enum ScenarioChainFactory {

    INSTANCE;

    public Chain create(List<OperationConfigObject> steps) {
        System.out.println("Senaryo zinciri oluşturma işlemi başlatıldı.");
        ChainBuilder chainBuilder = new ChainBuilder();
        steps.stream().forEach(operationConfigObject -> {
            Chain chain = createChain(operationConfigObject);
            chainBuilder.addChain(chain);
            System.out.println(chain.getOperationType() + " operasyonu zincire eklendi");
        });

        return chainBuilder.build();
    }

    private Chain createChain(OperationConfigObject operationConfigObject) {
        Operation operation = OperationFactoryStrategy.INSTANCE.create(operationConfigObject);
        return new OperationChain(operation);
    }
}
