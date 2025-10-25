package com.example.cricBuzz_backend.converter;

import com.example.cricBuzz_backend.dto.request.TeamRequest;
import com.example.cricBuzz_backend.dto.response.TeamResponse;
import com.example.cricBuzz_backend.model.entity.Team;

public class TeamConverter {

    public static Team teamRequestToTeam(TeamRequest teamRequest){
        return Team.builder()
                .teamName(teamRequest.getTeamName())
                .iccRanking(teamRequest.getIccRanking())
                .iccPoints(teamRequest.getIccPoints())
                .build();
    }

    public static TeamResponse teamToTeamResponse(Team team){
        return TeamResponse.builder()
                .teamName(team.getTeamName())
                .iccRanking(team.getIccRanking())
                .build();
    }
}
