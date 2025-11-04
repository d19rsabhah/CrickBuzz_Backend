package com.example.cricBuzz_backend.service;

import com.example.cricBuzz_backend.converter.MatchConverter;
import com.example.cricBuzz_backend.dto.request.CricketMatchRequest;
import com.example.cricBuzz_backend.dto.response.CricketMatchResponse;
import com.example.cricBuzz_backend.exception.TeamNotFoundException;
import com.example.cricBuzz_backend.model.entity.CricketMatch;
import com.example.cricBuzz_backend.model.entity.Team;
import com.example.cricBuzz_backend.repository.CricketMatchRepository;
import com.example.cricBuzz_backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CricketMatchRepository cricketMatchRepository;

    public CricketMatchResponse registerMatch(CricketMatchRequest cricketMatchRequest, int teamAId, int teamBId) {

        Optional<Team> optionalTeamA = teamRepository.findById(teamAId);
        Optional<Team> optionalTeamB = teamRepository.findById(teamBId);

        if(optionalTeamA.isEmpty() || optionalTeamB.isEmpty()){
            throw new TeamNotFoundException("Invalid Team Details!");
        }

        Team teamA = optionalTeamA.get();
        Team teamB = optionalTeamB.get();


        CricketMatch match = MatchConverter.cricketMatchRequestToCricketMatch(cricketMatchRequest);

        List<Team> teams = List.of(teamA, teamB);
        match.setTeams(teams);

        teamA.getMatches().add(match);
        teamB.getMatches().add(match);

        CricketMatch saveMatch = cricketMatchRepository.save(match);
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        return MatchConverter.cricketMatchToCricketMatchResponse(saveMatch);

    }
}
