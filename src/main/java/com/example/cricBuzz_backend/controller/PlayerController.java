package com.example.cricBuzz_backend.controller;


import com.example.cricBuzz_backend.dto.request.PlayerRequest;
import com.example.cricBuzz_backend.dto.response.PlayerResponse;
import com.example.cricBuzz_backend.model.entity.Player;
import com.example.cricBuzz_backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    public PlayerResponse addPlayer(@RequestBody PlayerRequest playerRequest){
        return playerService.addPlayer(playerRequest);
    }

    @GetMapping
    public Player getPlayer(@RequestParam("player-id") int player_Id){
        return playerService.getPlayer(player_Id);
    }
}
