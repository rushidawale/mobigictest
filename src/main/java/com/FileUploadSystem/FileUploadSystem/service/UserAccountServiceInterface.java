package com.FileUploadSystem.FileUploadSystem.service;

import com.FileUploadSystem.FileUploadSystem.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountServiceInterface {
    String addUser(UserDTO user);
}
