//package com.media.service.copic.Repository;
//
//import org.springframework.stereotype.Repository;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Date;
//
//@Repository
//class FileSystemRepository {
//
//    String RESOURCES_DIR = FileSystemRepository.class.getResource("../../../images")
//            .getPath();
//
//    String save(byte[] content, String imageName) throws Exception {
//        Path newFile = Paths.get(RESOURCES_DIR + new Date().getTime() + "-" + imageName);
//        Files.createDirectories(newFile.getParent());
//
//        Files.write(newFile, content);
//
//        return newFile.toAbsolutePath()
//                .toString();
//    }
//
//
//}
//
//
