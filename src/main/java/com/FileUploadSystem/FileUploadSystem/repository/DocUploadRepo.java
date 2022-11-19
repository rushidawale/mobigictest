package com.FileUploadSystem.FileUploadSystem.repository;

import com.FileUploadSystem.FileUploadSystem.entity.DocumentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocUploadRepo extends JpaRepository<DocumentInfo,String> {
    @Query(value = "Select d from DocumentInfo d where d.uniqueCode =:uniqueCode")
    Optional<DocumentInfo> findByUniqueCode(@Param("uniqueCode") long uniqueCode);
}
