package com.FileUploadSystem.FileUploadSystem.controller;

import com.FileUploadSystem.FileUploadSystem.entity.DocumentInfo;
import com.FileUploadSystem.FileUploadSystem.model.UserDTO;
import com.FileUploadSystem.FileUploadSystem.service.DocumentUploadServiceImpl;
import com.FileUploadSystem.FileUploadSystem.service.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.FileUploadSystem.FileUploadSystem.service.UserAccountServiceInterface;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
@CrossOrigin
@RestController
public class UserAccount {

    @Autowired
    private UserAccountServiceImpl userAccountServiceInterface;

    @Autowired
    private DocumentUploadServiceImpl documentUploadService;


    @PostMapping(value = "/register")
    public String addUser(@RequestBody UserDTO user)
    {
        String result = userAccountServiceInterface.addUser(user);
        return result;

    }

    @PostMapping(value = "/login")
    public String loginUser(@RequestBody UserDTO user)
    {
        String result  = userAccountServiceInterface.getUserDetail(user);
        return result;
    }




}
