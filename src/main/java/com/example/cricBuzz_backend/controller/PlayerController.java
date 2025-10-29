package com.example.cricBuzz_backend.controller;


import com.example.cricBuzz_backend.dto.request.PlayerRequest;
import com.example.cricBuzz_backend.dto.response.PlayerResponse;
import com.example.cricBuzz_backend.model.entity.Player;
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
    public ResponseEntity<?> addPlayer(@RequestBody PlayerRequest playerRequest){
        PlayerResponse addResponse = playerService.addPlayer(playerRequest);
        return new ResponseEntity<>(addResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getPlayer(@RequestParam("player-id") int player_Id){
        PlayerResponse getResponse = playerService.getPlayer(player_Id);
        return new ResponseEntity<>(getResponse, HttpStatus.OK);
    }

//    @GetMapping("/gender/{gender}")
//    public ResponseEntity<?> getPlayerByGender(@PathVariable("gender") String genderStr) {
//        try {
//            Gender gender = Gender.valueOf(genderStr.toUpperCase());
//            List<PlayerResponse> players = playerService.getPlayerByGender(gender);
//
//            if (players.isEmpty()) {
//                return new ResponseEntity<>("No Data Found", HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(players, HttpStatus.OK);
//
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>("Invalid gender. Allowed values: MALE, FEMALE.", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/gender/{gender}/speciality/{speciality}")
//    public ResponseEntity<?> getPlayerByGenderAndSpeciality(@PathVariable("gender") String gender,
//                                                            @PathVariable("speciality") String specialization){
//        try {
//
//            List<PlayerResponse> players = playerService.getPlayerByGenderAndSpeciality(gender.toUpperCase(), specialization.toUpperCase());
//
//            if (players.isEmpty()) {
//                return new ResponseEntity<>("No Data Found", HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(players, HttpStatus.OK);
//
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>("Invalid input!", HttpStatus.BAD_REQUEST);
//        }
//    }

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
