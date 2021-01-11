package com.media.service.copic.Resource;

import org.springframework.core.io.FileSystemResource;

import java.nio.file.Paths;

public class FileResource {
    FileSystemResource findInFileSystem(String location) {
        try {
            return new FileSystemResource(Paths.get(location));
        } catch (Exception e) {
            // Handle access or file not found problems.
            throw new RuntimeException();
        }
    }
}
