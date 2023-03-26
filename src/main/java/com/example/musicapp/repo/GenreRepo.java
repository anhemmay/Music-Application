package com.example.musicapp.repo;

import com.example.musicapp.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Integer> {
    List<Genre> findAllByNameContainingIgnoreCase(String name);
}
