package com.media.service.copic.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ImageDB")
public class ImageModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    String Location;

    public ImageModel(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
