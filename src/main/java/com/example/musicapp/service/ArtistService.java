package com.example.musicapp.service;

import com.example.musicapp.dto.ArtistDTO;
import com.example.musicapp.entity.Artist;
import com.example.musicapp.exception.ResourceNotFoundException;
import com.example.musicapp.repo.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepo artistRepo;
    public Set<ArtistDTO> findAllByName(String name){

        return artistRepo
                .findAllByStageNameContainingIgnoreCase(name)
                .stream()
                .map(artist -> new ArtistDTO(artist))
                .collect(Collectors.toSet());
    }
    public Artist findById(Integer id){
        return artistRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException());
    }
}
