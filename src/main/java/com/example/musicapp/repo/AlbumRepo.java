package com.example.musicapp.repo;

import com.example.musicapp.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepo extends JpaRepository<Album, Integer> {
    List<Album> findAllByTitleContainingIgnoreCase(String name);
}
