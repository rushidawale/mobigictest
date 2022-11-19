package com.FileUploadSystem.FileUploadSystem.service;

import com.FileUploadSystem.FileUploadSystem.entity.DocumentInfo;
import com.FileUploadSystem.FileUploadSystem.model.ResponseMessage;
import com.FileUploadSystem.FileUploadSystem.repository.DocUploadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class DocumentUploadServiceImpl implements DocumentUploadServiceInterface {

    @Autowired
    private DocUploadRepo docUploadRepo;

    public DocumentInfo store(MultipartFile file) throws IOException {
        System.out.println("***before");
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println("***before after");
        Random rnd = new Random();
        int uniqueNum = rnd.nextInt(999999);

        DocumentInfo documentInfo = DocumentInfo.builder().name(fileName).data(file.getBytes()).type(file.getContentType()).uniqueCode(uniqueNum).build();

        System.out.println("***after");
        return docUploadRepo.save(documentInfo);
    }

    public Optional<DocumentInfo> getFile(long uniqueCode) {
        return docUploadRepo.findByUniqueCode(uniqueCode);
    }

    public Stream<DocumentInfo> getAllFiles() {
        return docUploadRepo.findAll().stream();
    }

    public ResponseEntity<ResponseMessage> removeFile(long uniqueCode) {
        Optional<DocumentInfo> documentInfo = docUploadRepo.findByUniqueCode(uniqueCode);
        try
        {
            docUploadRepo.delete(documentInfo.get());
            String message = "File removed successfully!!!";
            return  ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        }
        catch (Exception ex)
        {
            String message = "File not found " +"!";
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(message));
        }




    }
}
