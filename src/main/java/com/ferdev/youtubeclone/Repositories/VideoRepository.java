package com.ferdev.youtubeclone.Repositories;

import com.ferdev.youtubeclone.Entities.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
}
