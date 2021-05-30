package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.FileInfo;


public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName(String fileName);
}
