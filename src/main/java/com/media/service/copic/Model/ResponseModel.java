package com.media.service.copic.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

    private String name;
    private String url;
    private String type;
    private long size;

}
