package com.ferdev.youtubeclone.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "Video")
public class Video {

    @Id
    private String id;
    private String title;
    private String description;
    private String userId;
    private Integer likes;
    private Integer disLikes;
    private Set<String> tags;
    private String videoUrl;
    private VideoStatus videoStatus;
    private Integer viewCount;
    private String thumbnailUrl;
    private List<Comment> commentList;
}
