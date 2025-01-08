package net.csibio.labic.service.impl;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import lombok.extern.slf4j.Slf4j;
import net.csibio.labic.service.FileService;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service("fileService")
@Slf4j
public class FileServiceImpl implements FileService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations gridFsOperations;



    /**
     * 通过文件 ID 返回文件
     */
    public GridFsResource getFile(String fileId) {
        return gridFsOperations.getResource(gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId))));
    }

    /**
     * 存储文件到MongoDB
     *
     * @param file 要存储的文件
     * @return 文件的ID
     * @throws IOException 如果文件读取或存储过程中出错
     */
    @Override
    public String storeFile(MultipartFile file) throws IOException {
        GridFSUploadOptions options = new GridFSUploadOptions()
                .metadata(new Document("fileName", file.getOriginalFilename()));

        ObjectId fileId = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType(), options);
        return fileId.toString();
    }

    /**
     * 从MongoDB下载文件
     *
     * @param fileId 文件的ID
     * @return 文件资源
     * @throws IOException 如果文件下载过程中出错
     */
    @Override
    public GridFsResource downloadFile(String fileId) {
        Query query = Query.query(Criteria.where("_id").is(new ObjectId(fileId)));
        Optional<GridFSFile> gridFSFile = Optional.of(gridFsTemplate.findOne(query));

        return gridFsTemplate.getResource(gridFSFile.get());
    }

    /**
     * 删除文件
     *
     * @param fileId 文件的ID
     */
    @Override
    public void deleteFile(String fileId) {
        Query query = Query.query(Criteria.where("_id").is(new ObjectId(fileId)));
        gridFsTemplate.delete(query);
    }
}
