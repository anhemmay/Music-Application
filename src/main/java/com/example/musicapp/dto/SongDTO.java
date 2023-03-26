package com.example.musicapp.dto;


import com.example.musicapp.entity.Song;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class SongDTO {
    private Integer id;
    private String name;
    private String imageUrl;
    private String songUrl;
    private Collection<String> artistsName;
    private String genre;
    private String album;
    public SongDTO(Song song) {
        this.id = song.getId();
        this.name = song.getName();
        this.imageUrl = song.getImageUrl();
        this.songUrl = song.getSongUrl();
        this.artistsName = song.getArtists().stream().map(artist -> artist.getStageName()).collect(Collectors.toSet());
        this.genre = song.getGenre().getName();
        this.album = song.getAlbum().getTitle();
    }
}
