package com.example.musicapp.dto;


import com.example.musicapp.entity.Favorite;
import lombok.Getter;

@Getter
public class FavoriteDTO{
    private Integer id;
    private UserDTO user;
    private SongDTO song;

    public FavoriteDTO(Favorite favorite) {
        this.id = favorite.getId();
        this.user = new UserDTO(favorite.getUser());
        this.song = new SongDTO(favorite.getSong());
    }
}
