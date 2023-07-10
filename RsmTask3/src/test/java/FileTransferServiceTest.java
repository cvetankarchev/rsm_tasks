import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileTransferServiceTest {
    @Test
    public void testTransferFiles() {
        // Mock the DownloadService
        DownloadService downloadService = new DownloadService() {
            @Override
            public List<DownloadInfo> getDownloadInfos(long packageId) {
                // Simulate the download info retrieval based on the package ID
                // Return a list of DownloadInfo objects for testing

                List<DownloadInfo> downloadInfos = new ArrayList<>();
                downloadInfos.add(new DownloadInfoImpl(123, "file1.txt", "key1", "http://example.com/file1.txt"));
                downloadInfos.add(new DownloadInfoImpl(456, "file2.jpg", "key2", "http://example.com/file2.jpg"));
                downloadInfos.add(new DownloadInfoImpl(789, "file3.exe", "key3", "http://example.com/file3.exe"));
                return downloadInfos;
            }

            @Override
            public InputStream downloadFile(String downloadURL) throws Exception {
                // Simulate the file download based on the download URL
                // Return an InputStream for testing

                String fileContent = "Test file content";
                return new ByteArrayInputStream(fileContent.getBytes());
            }
        };

        // Mock the UploadService
        UploadService uploadService = new UploadService() {
            @Override
            public void doUpload(String key, InputStream data, int size) throws Exception {
                // Simulate the file upload based on the key, data, and size
                // Perform necessary assertions for testing

                // Here, we are simply asserting that the key, data, and size are not null
                assertNotNull(key);
                assertNotNull(data);
                assertTrue(size > 0);
            }
        };

        // Create the FileTransferService using the mock services
        FileTransferService fileTransferService = new FileTransferService(downloadService, uploadService);

        // Execute the file transfer and get the report
        Report report = fileTransferService.transferFiles(123456);

        // Print the report in the console
        System.out.println("File Transfer Report");
        System.out.println("Total Successes: " + report.getSuccessCount());
        System.out.println("Total Failures: " + report.getFailureCount());
        System.out.println("Total Time: " + report.getTotalTime());

        // Print information for each transfer result
        for (TransferResult result : report.getTransferResults()) {
            System.out.println("---");
            System.out.println("File Name: " + result.getFileName());
            System.out.println("Upload Time: " + result.getUploadTime());
            System.out.println("Success: " + result.isSuccess());
            System.out.println("Error Message: " + result.getErrorMessage());
        }

        // Perform necessary assertions on the report for testing
        assertEquals(2, report.getSuccessCount());
        assertEquals(1, report.getFailureCount());
    }
}
