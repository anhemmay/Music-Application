package com.example.musicapp.service;

import com.example.musicapp.dto.GenreDTO;
import com.example.musicapp.entity.Genre;
import com.example.musicapp.repo.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GenreService {
    @Autowired
    private GenreRepo genreRepo;
    public Set<GenreDTO> findAllByName(String name){
        return genreRepo
                .findAllByNameContainingIgnoreCase(name)
                .stream()
                .map(genre -> new GenreDTO(genre))
                .collect(Collectors.toSet());
    }
}
