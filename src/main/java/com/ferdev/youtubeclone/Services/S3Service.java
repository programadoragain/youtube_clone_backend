package com.ferdev.youtubeclone.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class S3Service implements FileService{

    @Override
    public String uploadFile(MultipartFile file) {
        //Upload file to AWS
    }

}
