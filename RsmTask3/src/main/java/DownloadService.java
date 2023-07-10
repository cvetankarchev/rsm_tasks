import java.io.InputStream;
import java.util.List;

public interface DownloadService {
    List<DownloadInfo> getDownloadInfos(long packageId);
    InputStream downloadFile(String downloadURL) throws Exception;
}

