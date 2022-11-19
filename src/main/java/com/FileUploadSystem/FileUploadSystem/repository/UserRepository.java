package com.FileUploadSystem.FileUploadSystem.repository;

import com.FileUploadSystem.FileUploadSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    @Query(value = "Select u from User u where u.userName=:userName")
    Optional<User> findByUserName(@Param("userName") String userName);
}
