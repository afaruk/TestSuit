package testsuit.chain;

public class ChainBuilder {

    private Chain startPoint;
    private Chain endPoint;


    Chain addChain(Chain chain) {
        if (startPoint == null) {
            startPoint = chain;
            endPoint = chain;
            return chain;
        }

        endPoint.setNextChain(chain);
        endPoint = chain;
        return chain;
    }

    Chain build() {
        return startPoint;
    }
}
