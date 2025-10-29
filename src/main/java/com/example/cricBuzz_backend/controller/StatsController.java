package com.example.cricBuzz_backend.controller;

import com.example.cricBuzz_backend.dto.request.StatsRequest;
import com.example.cricBuzz_backend.exception.PlayerNotFoundException;
import com.example.cricBuzz_backend.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @PostMapping
    public ResponseEntity<String> addStatsForPlayer(@RequestBody StatsRequest statsRequest,
                                                    @RequestParam("player-id") int playerId) {
        try {
            String response = statsService.addStatsForPlayer(statsRequest, playerId);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (PlayerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
