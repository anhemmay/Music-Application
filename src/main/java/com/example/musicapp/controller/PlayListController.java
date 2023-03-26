package com.example.musicapp.controller;

import com.example.musicapp.dto.PlayListDTO;
import com.example.musicapp.dto.SongDTO;
import com.example.musicapp.service.PlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/{id}/playlists")
public class PlayListController {
    private final PlayListService playListService;
    @GetMapping
    public ResponseEntity<Set<PlayListDTO>> getAllPlayListByUser(@PathVariable(name = "id") Integer id){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        return ResponseEntity.ok().headers(headers).body(playListService.findAllPlaylistByUser(id));
    }
    @PostMapping ("/create")
    public ResponseEntity<?> createNewPlayList(@PathVariable Integer id,
                                               @RequestBody PlayListDTO playlistDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(playListService.createPlayListByUser(id, playlistDTO));
    }

    @PostMapping ("/playlist/{playlistId}/song")
    public ResponseEntity<PlayListDTO> addSongToPlayList(@PathVariable(name = "playlistId") Integer playlistId,
                                                         @RequestBody SongDTO songDTO){
        PlayListDTO playListDTO = playListService.addSongToPlayList(playlistId, songDTO.getId());
        return ResponseEntity.ok().body(playListDTO);
    }

    @DeleteMapping("/playlist")
    public ResponseEntity<?> deletePlayListByUser(@RequestParam(name = "playlist_id") Integer playlistId){
        playListService.deletePlayList(playlistId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/playlist/{playlistId}/songs")
    public ResponseEntity<Set<SongDTO>> getAllSongByPlayList(@PathVariable(name = "playlistId")Integer playlistId){
        return ResponseEntity.ok().body(playListService.findAllSongByPlayList(playlistId));
    }
    @DeleteMapping
    public ResponseEntity<?> deleteSongInPlayList(@RequestParam(name = "playlist_id") Integer playlistId,@RequestParam(name = "song_id") Integer songId){
        playListService.deleteSongInPlayList(songId, playlistId);
        return ResponseEntity.noContent().build();
    }
}
