package com.example.cricBuzz_backend.controller;

import com.example.cricBuzz_backend.dto.request.TeamRequest;
import com.example.cricBuzz_backend.dto.response.PlayerResponse;
import com.example.cricBuzz_backend.dto.response.TeamResponse;
import com.example.cricBuzz_backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping
    public ResponseEntity addTeam(@RequestBody TeamRequest teamRequest){
        TeamResponse addResponse = teamService.addTeam(teamRequest);
        return new ResponseEntity(addResponse, HttpStatus.CREATED);

    }
}
