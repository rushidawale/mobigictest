package com.FileUploadSystem.FileUploadSystem.entity;

import lombok.*;
import net.bytebuddy.build.Plugin;
import org.apache.catalina.Engine;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentInfo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;


    private String name;


    private String type;

    private long uniqueCode;


    @Lob
    private byte[] data;

//    public DocumentInfo(String name, String type, byte[] data,long uniqueCode) {
//        this.name = name;
//        this.type = type;
//        this.data = data;
//        this.uniqueCode=uniqueCode;
//    }


}
