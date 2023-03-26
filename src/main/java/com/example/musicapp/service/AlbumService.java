package com.example.musicapp.service;


import com.example.musicapp.dto.AlbumDTO;
import com.example.musicapp.repo.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepo albumRepo;
    public Set<AlbumDTO> findAllByName(String name){
        return albumRepo
                .findAllByTitleContainingIgnoreCase(name)
                .stream()
                .map(album -> new AlbumDTO(album))
                .collect(Collectors.toSet());
    }
}
