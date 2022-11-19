package com.FileUploadSystem.FileUploadSystem.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class DocInfoDTO {

    private String docName;
    private String documentData;
}
