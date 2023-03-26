package com.example.musicapp.dto;


import com.example.musicapp.entity.Album;
import lombok.Getter;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Getter
public class AlbumDTO {
    private Integer id;
    private String title;
    private String imageUrl;
    private Date createdAt;

    private String description;


    public AlbumDTO(Album album) {
        this.id = album.getId();
        this.title = album.getTitle();
        this.imageUrl = album.getImageUrl();
        this.createdAt = album.getCreatedAt();
        this.description = album.getDescription();
    }
}
