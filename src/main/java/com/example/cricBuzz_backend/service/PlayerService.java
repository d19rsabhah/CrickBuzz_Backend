package com.example.cricBuzz_backend.service;

import com.example.cricBuzz_backend.model.entity.Player;
import com.example.cricBuzz_backend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }
}
