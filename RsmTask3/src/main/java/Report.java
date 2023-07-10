import java.util.List;

public class Report {
    private List<TransferResult> transferResults;
    private int successCount;
    private int failureCount;
    private long totalTime;

    public Report(List<TransferResult> transferResults, int successCount, int failureCount, long totalTime) {
        this.transferResults = transferResults;
        this.successCount = successCount;
        this.failureCount = failureCount;
        this.totalTime = totalTime;
    }

    public List<TransferResult> getTransferResults() {
        return transferResults;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public int getFailureCount() {
        return failureCount;
    }

    public long getTotalTime() {
        return totalTime;
    }
}
