package com.example.musicapp.service;

import com.example.musicapp.dto.PlayListDTO;
import com.example.musicapp.dto.UserDTO;
import com.example.musicapp.exception.ResourceNotFoundException;
import com.example.musicapp.entity.User;
import com.example.musicapp.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User getUser(Integer id) {

        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public void updateUser(User user, Integer id) {
        User existedUser = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        existedUser.setName(user.getName());
        existedUser.setDob(user.getDob());
        existedUser.setPassword(user.getPassword());
        existedUser.setImageUrl(user.getImageUrl());
        existedUser.setPlayLists(user.getPlayLists());
        userRepo.save(existedUser);
        userRepo.flush();

    }
}
