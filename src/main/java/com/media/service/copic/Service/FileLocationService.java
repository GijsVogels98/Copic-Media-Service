package com.media.service.copic.Service;


import com.media.service.copic.Model.ImageModel;
import com.media.service.copic.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileLocationService {

//    @Autowired
//    private FileSystemRepository fileSystemRepository;

    @Autowired
    private ImageRepository imageRepository;

//    Long save(byte[] bytes, String imageName) throws Exception{
//        return imageRepository.save(new ImageModel())
//    }
}
