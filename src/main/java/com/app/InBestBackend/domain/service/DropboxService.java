package com.app.InBestBackend.domain.service;

/*import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import org.springframework.beans.factory.annotation.Value;*/
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

//import java.io.InputStream;

@Service
public class DropboxService {
    /*@Value("${dropbox.accessToken}")
    private String accessToken;

    public void uploadFile(MultipartFile file, Long id_negocio, String fileName) throws Exception {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("SaveInvest").build();
        DbxClientV2 client = new DbxClientV2(config, accessToken);

        try (InputStream in = file.getInputStream()) {
            FileMetadata metadata = client.files().uploadBuilder("/" + id_negocio+ "/" + fileName+".jpg")
                    .uploadAndFinish(in);
        }
    }
    
    public FileMetadata downloadAllFilesInFolder(Long id_negocio, String fileName) throws Exception {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("SaveInvest").build();
        DbxClientV2 client = new DbxClientV2(config, accessToken);

        try (DbxDownloader<FileMetadata> downloader = client.files().getPreview("/" + id_negocio + "/" + fileName + ".jpg")) {
            return downloader.getResult();
        }
    }*/
}
