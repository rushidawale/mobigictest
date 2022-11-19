package com.FileUploadSystem.FileUploadSystem.controller;

import com.FileUploadSystem.FileUploadSystem.entity.DocumentInfo;
import com.FileUploadSystem.FileUploadSystem.model.ResponseFile;
import com.FileUploadSystem.FileUploadSystem.model.ResponseMessage;
import com.FileUploadSystem.FileUploadSystem.service.DocumentUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class DocUploadController {

    @Autowired
    private DocumentUploadServiceImpl documentUploadService;

    @PostMapping(path="/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ResponseMessage> uploadFile(@RequestPart("file") MultipartFile file) {
        String message = "";
        try {
            documentUploadService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }


    }

    @DeleteMapping("/deleteFile/{uniqueCode}")
    public ResponseEntity<ResponseMessage> removeFile(@PathVariable long uniqueCode)
    {

       ResponseEntity<ResponseMessage> response =  documentUploadService.removeFile(uniqueCode);
        return response;

    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = documentUploadService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{uniqueCode}")
    public ResponseEntity<byte[]> getFile(@PathVariable long uniqueCode) {
        Optional<DocumentInfo> documentInfo = documentUploadService.getFile(uniqueCode);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documentInfo.get().getName() + "\"")
                .body(documentInfo.get().getData());
    }
}
