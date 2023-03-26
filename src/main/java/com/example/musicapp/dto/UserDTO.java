package com.example.musicapp.dto;

import com.example.musicapp.entity.User;
import lombok.Getter;

import java.util.Date;


@Getter
public class UserDTO {
    private Integer id;
    private String name;
    private String username;
    private Date dob;
    private String imageUrl;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.dob = user.getDob();
        this.imageUrl = user.getImageUrl();
    }
}
