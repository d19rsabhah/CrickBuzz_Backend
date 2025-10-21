package com.example.cricBuzz_backend.controller;


import com.example.cricBuzz_backend.model.entity.Player;
import com.example.cricBuzz_backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    public Player addPlayer(@RequestBody Player player){
        return playerService.addPlayer(player);
    }
}
