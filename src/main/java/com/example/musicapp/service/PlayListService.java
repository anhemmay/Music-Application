package com.example.musicapp.service;

import com.example.musicapp.dto.PlayListDTO;
import com.example.musicapp.dto.SongDTO;
import com.example.musicapp.entity.PlayList;
import com.example.musicapp.entity.Song;
import com.example.musicapp.entity.User;
import com.example.musicapp.exception.ResourceNotFoundException;
import com.example.musicapp.repo.PlayListRepo;
import com.example.musicapp.repo.SongRepo;
import com.example.musicapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayListService {
    @Autowired
    private PlayListRepo playListRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SongRepo songRepo;

    public PlayListDTO createPlayListByUser(Integer userId, PlayListDTO playListDTO) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException());
        PlayList playList = new PlayList();
        playList.setName(playListDTO.getName());
        playList.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        playList.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
        playList.setUser(user);
        return new PlayListDTO(playListRepo.saveAndFlush(playList));

    }

    public PlayListDTO addSongToPlayList(Integer playlistId, Integer songId) {
        PlayList playList = playListRepo.findById(playlistId).orElseThrow(() -> new ResourceNotFoundException());
        Song song = songRepo.findById(songId).orElseThrow(() -> new ResourceNotFoundException());
        if (!playList.getSongs().contains(song)) {
            playList.getSongs().add(song);
            playListRepo.saveAndFlush(playList);
        }
        return new PlayListDTO(playList);
    }

    public void deletePlayList(Integer playlistId) {
        PlayList playList = playListRepo.findById(playlistId).orElse(null);
        if(playList != null){
            User user = playList.getUser();
            user.getPlayLists().remove(playList);
            playListRepo.deleteById(playlistId);
        }
    }

    public void deleteSongInPlayList(Integer songId, Integer playlistId){
        PlayList playList = playListRepo.findById(playlistId).orElse(null);
        Song song = songRepo.findById(songId).orElse(null);
        playList.getSongs().remove(song);
        song.getPlaylists().remove(playList);
        playListRepo.saveAndFlush(playList);
        songRepo.saveAndFlush(song);
    }

    public Set<PlayListDTO> findAllPlaylistByUser(Integer userId) {
        return playListRepo
                .findAllByUserId(userId)
                .stream()
                .map(playList -> new PlayListDTO(playList))
                .collect(Collectors.toSet());
    }

    public Set<SongDTO> findAllSongByPlayList(Integer playlistId) {
        return songRepo
                .findAllByPlaylistId(playlistId)
                .stream()
                .map(song -> new SongDTO(song))
                .collect(Collectors.toSet());
    }
}
