package com.example.musicapp.repo;

import com.example.musicapp.entity.PlayList;
import com.example.musicapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
