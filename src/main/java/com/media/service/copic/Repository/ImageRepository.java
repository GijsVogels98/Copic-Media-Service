package com.media.service.copic.Repository;

import com.media.service.copic.Model.ImageModel;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableEurekaClient
public interface ImageRepository extends JpaRepository<ImageModel, String> {
}
