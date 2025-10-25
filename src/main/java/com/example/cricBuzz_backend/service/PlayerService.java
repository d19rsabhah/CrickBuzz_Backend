package com.example.cricBuzz_backend.service;

import com.example.cricBuzz_backend.converter.PlayerConverter;
import com.example.cricBuzz_backend.dto.request.PlayerRequest;
import com.example.cricBuzz_backend.dto.response.PlayerResponse;
import com.example.cricBuzz_backend.exception.PlayerNotFoundException;
import com.example.cricBuzz_backend.model.entity.Player;
import com.example.cricBuzz_backend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponse addPlayer(PlayerRequest playerRequest) {

        Player player = PlayerConverter.playerRequestToPlayer(playerRequest);

        Player savedPlayer = playerRepository.save(player);

        return PlayerConverter.PlayerToPlayerResponse(savedPlayer);

    }

    public Player getPlayer(int playerId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isEmpty()){
            throw new PlayerNotFoundException("Invalid player id!");
        }
        return playerOptional.get();
    }
}
