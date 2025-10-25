package com.example.cricBuzz_backend.controller;


import com.example.cricBuzz_backend.dto.request.PlayerRequest;
import com.example.cricBuzz_backend.dto.response.PlayerResponse;
import com.example.cricBuzz_backend.model.entity.Player;
import com.example.cricBuzz_backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity addPlayer(@RequestBody PlayerRequest playerRequest){
        PlayerResponse addResponse = playerService.addPlayer(playerRequest);
        return new ResponseEntity(addResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getPlayer(@RequestParam("player-id") int player_Id){
        PlayerResponse getResponse = playerService.getPlayer(player_Id);
        return new ResponseEntity(getResponse, HttpStatus.OK);
    }
}
