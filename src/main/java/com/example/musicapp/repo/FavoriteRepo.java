package com.example.musicapp.repo;

import com.example.musicapp.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepo extends JpaRepository<Favorite,Integer> {
}
