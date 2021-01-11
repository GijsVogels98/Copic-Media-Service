package com.media.service.copic.Controllers;


import com.media.service.copic.Model.ImageModel;
import com.media.service.copic.Model.MessageModel;
import com.media.service.copic.Model.ResponseModel;
import com.media.service.copic.Repository.ImageRepository;
import com.media.service.copic.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/media/")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageRepository imageRepository;




//    public Long uploadImage(@RequestParam MultipartFile multipartImage) throws Exception {
//        ImageModel imageModel = new ImageModel();
//        imageModel.setName(multipartImage.getName());
//        imageModel.setContent(multipartImage.getBytes());
//
//        return imageRepository.save(imageModel).getId();
//    }

    @PostMapping(value = "/upload")
    public ResponseEntity<MessageModel> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        String message = "";
        try {
            imageService.store(file);
            message = "Uploaded image successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageModel(message));

        }catch (Exception e){
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageModel(message));
        }
    }

    @GetMapping("/images")
    public ResponseEntity<List<ResponseModel>> getListImages(){
        List<ResponseModel> images = imageService.getAllImages().map( dbFile -> {
          String imgDownloadUri = ServletUriComponentsBuilder
                  .fromCurrentContextPath()
                  .path("/images/")
                  .path(dbFile.getId())
                  .toUriString();

          return new ResponseModel(
                  dbFile.getName(),
                  imgDownloadUri,
                  dbFile.getType(),
                  dbFile.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(images);

    }

    @GetMapping("/img/{id}")
    public ResponseEntity<byte[]> getImg(@PathVariable String id){
        ImageModel imageModel = imageService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ imageModel.getName() +"\"")
                .body(imageModel.getData());
    }


}
