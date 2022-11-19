package com.FileUploadSystem.FileUploadSystem.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class UserDTO {

    private String userName;

    private String userPassword;
}
