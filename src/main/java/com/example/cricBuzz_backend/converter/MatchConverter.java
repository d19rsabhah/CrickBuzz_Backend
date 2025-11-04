package com.example.cricBuzz_backend.converter;

import com.example.cricBuzz_backend.dto.request.CricketMatchRequest;
import com.example.cricBuzz_backend.dto.response.CricketMatchResponse;
import com.example.cricBuzz_backend.dto.response.TeamResponse;
import com.example.cricBuzz_backend.model.entity.CricketMatch;

import java.util.ArrayList;
import java.util.List;

public class MatchConverter {

    public static CricketMatch cricketMatchRequestToCricketMatch(CricketMatchRequest cricketMatchRequest){
        return CricketMatch.builder()
                .title(cricketMatchRequest.getTitle())
                .matchType(cricketMatchRequest.getMatchType())
                .overs(cricketMatchRequest.getOvers())
                .place(cricketMatchRequest.getPlace())
                .build();

    }

    public static CricketMatchResponse cricketMatchToCricketMatchResponse(CricketMatch match){

        List<TeamResponse> teamResponseList = new ArrayList<>();
        TeamResponse teamResponseA = TeamConverter.teamToTeamResponse(match.getTeams().get(0));
        TeamResponse teamResponseB = TeamConverter.teamToTeamResponse(match.getTeams().get(1));

        teamResponseList.add(teamResponseA);
        teamResponseList.add(teamResponseB);

        return CricketMatchResponse.builder()
                .title(match.getTitle())
                .matchType(match.getMatchType())
                .place(match.getPlace())
                .startedAt(match.getStartedAt())
                .teams(teamResponseList)
                .build();
    }

}
