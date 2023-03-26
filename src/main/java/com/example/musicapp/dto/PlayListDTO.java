package com.example.musicapp.dto;
import com.example.musicapp.entity.PlayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayListDTO {
    private Integer id;
    private String name;
    private String userName;
    public PlayListDTO(PlayList playlist) {
        this.id = playlist.getId();
        this.name = playlist.getName();
        this.userName = playlist.getUser().getName();
    }
}
