package com.example.musicapp.service;

import com.example.musicapp.dto.SongDTO;
import com.example.musicapp.entity.Song;

import com.example.musicapp.exception.ResourceNotFoundException;
import com.example.musicapp.repo.SongRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class SongService {
    @Autowired
    private SongRepo songRepo;
    public List<Song> findAllByName(String name){
        return songRepo.findAllByName(name);
    }
    public Song createSong(Song song){
        return songRepo.saveAndFlush(song);
    }
    public Song findSong(Integer id){
        return songRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException());
    }

    public Set<SongDTO> findAllByCriteria(String keyword){
        return songRepo.searchSongs(keyword, PageRequest.of(0,10))
                .stream()
                .map(song -> new SongDTO(song))
                .collect(Collectors.toSet());
    }
}
