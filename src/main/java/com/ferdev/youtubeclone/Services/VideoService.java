package com.ferdev.youtubeclone.Services;

import com.ferdev.youtubeclone.Entities.Video;
import com.ferdev.youtubeclone.Repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VideoService {

    @Autowired
    private S3Service s3Service;

    @Autowired
    private VideoRepository videoRepository;

    public void uploadVideo(MultipartFile file) {
        String videoUrlInBucket= s3Service.uploadFile(file);
        Video video= new Video();
        video.setVideoUrl(videoUrlInBucket);

        videoRepository.save(video);
    }
}
