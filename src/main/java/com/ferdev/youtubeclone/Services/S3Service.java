package com.ferdev.youtubeclone.Services;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service implements FileService{

    public static final String S3_BUCKET_NAME = "youtube-clone-bucket-storage";
    private final AmazonS3Client awsS3Client; // Must be initialized, because the constructor.

    public S3Service(AmazonS3Client awsS3Client) {
        this.awsS3Client = awsS3Client;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        
        var filenameExtension= StringUtils.getFilenameExtension(file.getOriginalFilename());

        String key= UUID.randomUUID().toString() + filenameExtension;

        var metadata= new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try {
            awsS3Client.putObject(S3_BUCKET_NAME, key, file.getInputStream(), metadata);
        } catch (IOException ioException) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                                                "An Exception occurred while uploading the file");
        }

        awsS3Client.setObjectAcl(S3_BUCKET_NAME, key, CannedAccessControlList.PublicRead);

        return awsS3Client.getResourceUrl(S3_BUCKET_NAME, key);
    }

}
