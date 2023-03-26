package com.example.musicapp.repo;

import com.example.musicapp.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepo extends JpaRepository<Artist, Integer> {

    List<Artist> findAllByStageNameContainingIgnoreCase(String name);
}
