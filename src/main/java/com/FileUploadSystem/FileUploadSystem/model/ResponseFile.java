package com.FileUploadSystem.FileUploadSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFile {

    private String name;
    private String url;
    private String type;
    private long size;

}
