package com.FileUploadSystem.FileUploadSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocUploadResponse {

    private String name;
    private String url;
    private String type;
    private long size;

    public DocUploadResponse(String name, String url, String type, long size) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
    }

}
