package testsuit.result;

import testsuit.chain.ChainResult;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BatchResult extends AbstractResult {

    private List<ChainResult> chainResults = new ArrayList<>();

    public BatchResult(int sequenceNum) {
        super("Batch-" + sequenceNum);
    }

    public void addChainResult(ChainResult chainResult) {
        chainResults.add(chainResult);
    }

    public List<ChainResult> getChainResults() {
        return chainResults;
    }

    @Override
    public void addReport(StringJoiner joiner) {
        joiner.add("###########################################");
        addHeaderInfo(joiner);
        getChainResults().stream().forEach(chainResult -> {
            chainResult.addReport(joiner);
        });
        joiner.add("###########################################");
    }
}
