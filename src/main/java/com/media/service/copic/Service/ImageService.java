package com.media.service.copic.Service;


import com.media.service.copic.Model.ImageModel;
import com.media.service.copic.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageModel store(MultipartFile file) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ImageModel imageModel = new ImageModel(
                    fileName,
                    file.getContentType(),
                    file.getBytes()
                );
        return imageRepository.save(imageModel);
    }

    public ImageModel getFile(String id){
        return imageRepository.findById(id).get();
    }

    public Stream<ImageModel> getAllImages(){
        return imageRepository.findAll().stream();
    }



}
