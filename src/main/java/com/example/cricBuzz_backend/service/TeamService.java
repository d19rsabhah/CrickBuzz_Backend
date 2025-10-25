package com.example.cricBuzz_backend.service;

import com.example.cricBuzz_backend.converter.PlayerConverter;
import com.example.cricBuzz_backend.converter.TeamConverter;
import com.example.cricBuzz_backend.dto.request.TeamRequest;
import com.example.cricBuzz_backend.dto.response.TeamResponse;
import com.example.cricBuzz_backend.model.entity.Team;
import com.example.cricBuzz_backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public TeamResponse addTeam(TeamRequest teamRequest){
        Team team = TeamConverter.teamRequestToTeam(teamRequest);

        Team savedTeam = teamRepository.save(team);
        return TeamConverter.teamToTeamResponse(savedTeam);
    }
}
