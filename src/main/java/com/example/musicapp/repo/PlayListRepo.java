package com.example.musicapp.repo;

import com.example.musicapp.entity.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface PlayListRepo extends JpaRepository<PlayList, Integer> {
    List<PlayList> findAllByUserId(Integer id);
    void deleteById(Integer id);
}
