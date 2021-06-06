package testsuit.result;

import testsuit.chain.ChainResult;
import testsuit.common.DateUtil;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Reporter {


    public void printReport(TestResult result) {
        StringJoiner joiner = new StringJoiner("\n", "\n", "");

//        result.getBatchResults().stream().forEach(batchResutls -> {
//            printScenario(batchResutls, joiner);
//        });
        result.addReport(joiner);
        System.out.println(joiner.toString());
    }

    public void printScenario(BatchResult batchResult, StringJoiner joiner) {
        List<ChainResult> scenarioResult = batchResult.getChainResults();
        IntStream.range(0, scenarioResult.size()).forEach(index -> {
            printChainReport(joiner, scenarioResult.get(index), index);
        });
    }

    private void printChainReport(StringJoiner joiner, ChainResult result, int index) {
        joiner.add("Senaryo--" + index);
        joiner.add("Test Başlama :" + DateUtil.convertToDate(result.getStartTime()) +
                " Bitiş: " + DateUtil.convertToDate(result.getFinishedTime()));
        joiner.add("Test süresi: " + (result.getFinishedTime() - result.getStartTime()));

        result.getOperationResults().stream().forEach(operationResult -> {
            operationResult.addReport(joiner);
        });
    }
}
