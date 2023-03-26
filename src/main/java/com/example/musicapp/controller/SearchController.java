package com.example.musicapp.controller;

import com.example.musicapp.entity.Artist;
import com.example.musicapp.service.AlbumService;
import com.example.musicapp.service.ArtistService;
import com.example.musicapp.service.GenreService;
import com.example.musicapp.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SearchController {
    private final SongService songService;
    private final ArtistService artistService;
    private final GenreService genreService;
    private final AlbumService albumService;
    @GetMapping("/search")
    public ResponseEntity<Map<String, List<Object>>> search(@RequestParam String keyword){
        Map<String, List<Object>> listResult = new HashMap<>();
        listResult.put("Songs", new ArrayList<>(songService.findAllByCriteria(keyword)));
        listResult.put("Artists", new ArrayList<>(artistService.findAllByName(keyword)));
        listResult.put("Albums", new ArrayList<>(albumService.findAllByName(keyword)));
        listResult.put("Genres", new ArrayList<>(genreService.findAllByName(keyword)));
        return ResponseEntity.ok().body(listResult);
    }
}
