package com.example.cricBuzz_backend.service;

import com.example.cricBuzz_backend.converter.PlayerConverter;
import com.example.cricBuzz_backend.dto.request.PlayerRequest;
import com.example.cricBuzz_backend.dto.response.PlayerResponse;
import com.example.cricBuzz_backend.exception.DataNotFoundException;
import com.example.cricBuzz_backend.exception.PlayerNotFoundException;
import com.example.cricBuzz_backend.model.entity.Player;
import com.example.cricBuzz_backend.model.enum_classes.Gender;
import com.example.cricBuzz_backend.model.enum_classes.Specialization;
import com.example.cricBuzz_backend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponse addPlayer(PlayerRequest playerRequest) {

        Player player = PlayerConverter.playerRequestToPlayer(playerRequest);

        Player savedPlayer = playerRepository.save(player);

        return PlayerConverter.playerToPlayerResponse(savedPlayer);

    }

    public PlayerResponse getPlayer(int playerId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isEmpty()){
            throw new PlayerNotFoundException("Invalid player id!");
        }
        Player player = playerOptional.get();
        return PlayerConverter.playerToPlayerResponse(player);
    }

    public List<PlayerResponse> getPlayerByGender(Gender gender) {
        List<Player> players = playerRepository.findByGender(gender);

        if (players.isEmpty()) {
            throw new DataNotFoundException("No players found for gender: " + gender);
        }

        List<PlayerResponse> playerResponses = new ArrayList<>();
        for (Player player : players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        return playerResponses;
    }

    public List<PlayerResponse> getPlayerByGenderAndSpeciality(String gender, String specialization) {
        List<Player> players = playerRepository.findPlayerBasedOnGenderAndSpeciality(gender, specialization);

        if (players.isEmpty()) {
            throw new DataNotFoundException("No players found for gender: " + gender + " and speciality: " + specialization);
        }

        List<PlayerResponse> playerResponses = new ArrayList<>();
        for (Player player : players) {
            playerResponses.add(PlayerConverter.playerToPlayerResponse(player));
        }
        return playerResponses;
    }
}
