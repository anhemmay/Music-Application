package com.example.musicapp;


import com.example.musicapp.entity.Artist;
import com.example.musicapp.entity.Genre;
import com.example.musicapp.entity.Song;
import com.example.musicapp.entity.User;
import com.example.musicapp.repo.ArtistRepo;
import com.example.musicapp.repo.GenreRepo;
import com.example.musicapp.repo.SongRepo;

import com.example.musicapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class MusicAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicAppApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }
}
