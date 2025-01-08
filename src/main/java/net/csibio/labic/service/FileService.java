package net.csibio.labic.service;

import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String storeFile(MultipartFile file) throws IOException;

    GridFsResource downloadFile(String fileId);

    void deleteFile(String fileId);
    GridFsResource getFile(String fileId);
}
