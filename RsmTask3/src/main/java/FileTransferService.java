import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileTransferService {
    private DownloadService downloadService;
    private UploadService uploadService;

    public FileTransferService(DownloadService downloadService, UploadService uploadService) {
        this.downloadService = downloadService;
        this.uploadService = uploadService;
    }

    public Report transferFiles(long packageId) {
        List<DownloadInfo> downloadInfos = downloadService.getDownloadInfos(packageId);
        List<String> downloadedFileNames = new ArrayList<>();
        List<TransferResult> transferResults = new ArrayList<>();

        for (DownloadInfo downloadInfo : downloadInfos) {
            if (!isAllowedExtension(downloadInfo.getOriginalFileName())) {
                transferResults.add(new TransferResult(downloadInfo.getOriginalFileName(), false, "Invalid file extension"));
                continue;
            }

            if (isDuplicateFileName(downloadedFileNames, downloadInfo.getOriginalFileName())) {
                transferResults.add(new TransferResult(downloadInfo.getOriginalFileName(), false, "Duplicate file name"));
                continue;
            }

            try {
                InputStream data = downloadService.downloadFile(downloadInfo.getDownloadURL());
                uploadService.doUpload(downloadInfo.getFileKey(), data, downloadInfo.getSize());
                transferResults.add(new TransferResult(downloadInfo.getOriginalFileName(), true, null));
                downloadedFileNames.add(downloadInfo.getOriginalFileName());
            } catch (Exception e) {
                transferResults.add(new TransferResult(downloadInfo.getOriginalFileName(), false, e.getMessage()));
            }
        }

        int successCount = 0;
        int failureCount = 0;
        long totalTime = 0;
        for (TransferResult result : transferResults) {
            if (result.isSuccess()) {
                successCount++;
            } else {
                failureCount++;
            }
            totalTime += result.getUploadTime();
        }

        return new Report(transferResults, successCount, failureCount, totalTime);
    }

    private boolean isAllowedExtension(String fileName) {
        String extension = getFileExtension(fileName).toLowerCase();
        List<String> forbiddenExtensions = List.of("cmd", "com", "dll", "dmg", "exe", "iso", "jar", "js");
        return !forbiddenExtensions.contains(extension);
    }

    private boolean isDuplicateFileName(List<String> downloadedFileNames, String fileName) {
        return downloadedFileNames.contains(fileName);
    }

    private String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return "";
        }
        return fileName.substring(lastDotIndex + 1);
    }
}
