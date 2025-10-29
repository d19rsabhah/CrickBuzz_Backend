package com.example.cricBuzz_backend.service;

import com.example.cricBuzz_backend.converter.StatsConverter;
import com.example.cricBuzz_backend.dto.request.StatsRequest;
import com.example.cricBuzz_backend.exception.PlayerNotFoundException;
import com.example.cricBuzz_backend.model.entity.Player;
import com.example.cricBuzz_backend.model.entity.Stats;
import com.example.cricBuzz_backend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatsService {

    @Autowired
    PlayerRepository playerRepository;

    public String addStatsForPlayer(StatsRequest statsRequest, int playerId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isEmpty()) {
            throw new PlayerNotFoundException("Invalid Player Id!");
        }

        Player player = playerOptional.get();
        Stats stats = StatsConverter.statsRequestToStats(statsRequest);
        stats.setPlayer(player);

        player.getStatsList().add(stats); // add to list
        playerRepository.save(player);

        return "Stats added for player: " + player.getName() + " (" + stats.getMatchType() + ")";
    }
}
