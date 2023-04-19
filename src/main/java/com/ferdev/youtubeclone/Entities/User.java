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
@Document(value = "User")
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<String> subscribedToUsers;
    private Set<String> suscribers;
    private List<String> videoHistory;
    private Set<String> likedVideos;
    private Set<String> disLikedVideos;
}
