package com.docent.dsel.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@Log4j2
public class FileController {
    @Value("${com.docent.imgUpload.path}")// import 시에 springframework으로 시작하는 Value
    private String imgUploadPath;

    @Value("${com.docent.audioUpload.path}")
    private String audioUploadPath;

    //@ApiOperation(value = "view 파일", notes = "GET방식으로 첨부파일 조회") //Swagger UI
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFileGET(@PathVariable String fileName){

        Resource resource = new FileSystemResource(imgUploadPath+ File.separator + fileName);
        String resourceName = resource.getFilename();
        HttpHeaders headers = new HttpHeaders();

        try{
            headers.add("Content-Type", Files.probeContentType( resource.getFile().toPath() ));
        } catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    @GetMapping("/audio/{fileName}")
    public ResponseEntity<Resource> audioFileGET(@PathVariable String fileName){

        Resource resource = new FileSystemResource(audioUploadPath+ File.separator + fileName);
        String resourceName = resource.getFilename();
        HttpHeaders headers = new HttpHeaders();

        try{
            headers.add("Content-Type", Files.probeContentType( resource.getFile().toPath() ));
        } catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }
    @GetMapping("/defaultImage")
    public ResponseEntity<byte[]> defaultImage(String fileName) {

        File targetFileImg = new File("C:\\projectFiles\\defaultImage\\" + fileName);

        try {
            String mimeType = Files.probeContentType(targetFileImg.toPath());

            byte[] data = FileCopyUtils.copyToByteArray(targetFileImg);

            return ResponseEntity.ok().header("Content-Type", mimeType)
                    .body(data);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        }
    }
}
