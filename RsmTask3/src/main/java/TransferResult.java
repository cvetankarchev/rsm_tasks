public class TransferResult {
    private String fileName;
    private boolean success;
    private String errorMessage;
    private long uploadTime;

    public TransferResult(String fileName, boolean success, String errorMessage) {
        this.fileName = fileName;
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(long uploadTime) {
        this.uploadTime = uploadTime;
    }
}
