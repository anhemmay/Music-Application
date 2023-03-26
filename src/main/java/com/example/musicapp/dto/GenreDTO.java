package com.example.musicapp.dto;


import com.example.musicapp.entity.Genre;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Getter
public class GenreDTO{
    private Integer id;
    private String name;
    private Collection<String> songs;

    public GenreDTO(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
        this.songs = genre.getSongs().stream().map(song -> song.getName()).collect(Collectors.toSet());
    }
}
