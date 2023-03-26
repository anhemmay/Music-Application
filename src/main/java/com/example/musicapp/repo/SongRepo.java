package com.example.musicapp.repo;

import com.example.musicapp.entity.Song;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

@Repository
public interface SongRepo extends JpaRepository<Song, Integer> {
    List<Song> findAllByName(String query);
    @Query("SELECT DISTINCT s FROM Song s " +
            "LEFT JOIN s.artists a " +
            "WHERE s.name LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR a.stageName LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR s.genre.name LIKE LOWER(CONCAT('%', :keyword, '%'))" +
            "OR s.album.title LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Song> searchSongs(@Param("keyword") String keyword, Pageable pageable);
    @Query("SELECT s FROM Song s INNER JOIN s.playlists a WHERE a.id = :id")
    Set<Song> findAllByPlaylistId(Integer id);
}
