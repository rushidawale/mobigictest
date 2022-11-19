package com.FileUploadSystem.FileUploadSystem.service;

import com.FileUploadSystem.FileUploadSystem.entity.User;
import com.FileUploadSystem.FileUploadSystem.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.FileUploadSystem.FileUploadSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountServiceInterface {

    @Autowired
    private UserRepository userRepository;
    @Override
    public String addUser(UserDTO user) {

        User entity = User.builder().
                userName(user.getUserName()).
                userPassword(user.getUserPassword()).
                build();
        userRepository.save(entity);

        return "User Registration Successfull!!";

    }

    public String getUserDetail(UserDTO user) {

        Optional<User> userOpt = userRepository.findByUserName(user.getUserName());
        if(user.getUserPassword().equals(userOpt.get().getUserPassword()))
        {
            return "Login Successfull!!";
        }
        else {
            return "Invalid Password";
        }
    }
}
