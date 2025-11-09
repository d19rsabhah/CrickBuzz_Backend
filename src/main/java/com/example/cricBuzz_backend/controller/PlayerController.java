package com.example.cricBuzz_backend.controller;


import com.example.cricBuzz_backend.dto.request.PlayerRequest;
import com.example.cricBuzz_backend.dto.response.PlayerResponse;
import com.example.cricBuzz_backend.model.enum_classes.Gender;
import com.example.cricBuzz_backend.model.enum_classes.Specialization;
import com.example.cricBuzz_backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity<?> addPlayer(@RequestBody PlayerRequest playerRequest,
                                       @RequestParam("team-id") int teamId) {

        PlayerResponse addResponse = playerService.addPlayer(playerRequest, teamId);
        return new ResponseEntity<>(addResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getPlayer(@RequestParam("player-id") int player_Id){
        PlayerResponse getResponse = playerService.getPlayer(player_Id);
        return new ResponseEntity<>(getResponse, HttpStatus.OK);
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<?> getPlayerByGender(@PathVariable("gender") String genderStr) {
        Gender gender = Gender.valueOf(genderStr.toUpperCase());
        List<PlayerResponse> players = playerService.getPlayerByGender(gender);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/gender/{gender}/speciality/{speciality}")
    public ResponseEntity<?> getPlayerByGenderAndSpeciality(
            @PathVariable("gender") String gender,
            @PathVariable("speciality") String specialization) {
        Gender _gender = Gender.valueOf(gender.toUpperCase());
        Specialization _specialization = Specialization.valueOf(specialization.toUpperCase());
        List<PlayerResponse> players = playerService.getPlayerByGenderAndSpeciality(
                gender.toUpperCase(), specialization.toUpperCase());
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

}
