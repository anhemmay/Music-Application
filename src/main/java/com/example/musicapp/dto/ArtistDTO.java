package com.example.musicapp.dto;

;

import com.example.musicapp.entity.Artist;
import lombok.Getter;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Getter
public class ArtistDTO{
        private Integer id;
        private String stageName;
        private String realName;
        private Date dob;
        private String description;
        private String imageUrl;

    public ArtistDTO(Artist artist) {
        this.id = artist.getId();
        this.stageName = artist.getStageName();
        this.realName = artist.getRealName();
        this.dob = artist.getDob();
        this.description = artist.getDescription();
        this.imageUrl = artist.getImageUrl();

    }
}

