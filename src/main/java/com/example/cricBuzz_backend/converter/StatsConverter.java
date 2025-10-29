package com.example.cricBuzz_backend.converter;

import com.example.cricBuzz_backend.dto.request.StatsRequest;
import com.example.cricBuzz_backend.model.entity.Stats;

public class StatsConverter {

    public static Stats statsRequestToStats(StatsRequest statsRequest){
        return Stats.builder()
                .matchType(statsRequest.getMatchType())
                .matches(statsRequest.getMatches())
                .ballsBowled(statsRequest.getBallsBowled())
                .inningsBatted(statsRequest.getInningsBatted())
                .inningsBowled(statsRequest.getInningsBowled())
                .runsConceded(statsRequest.getRunsConceded())
                .runs(statsRequest.getRuns())
                .wickets(statsRequest.getWickets())
                .ballsFaced(statsRequest.getBallsFaced())
                .highestScore(statsRequest.getHighestScore())
                .battingAverage(statsRequest.getBattingAverage())
                .bowlingAverage(statsRequest.getBowlingAverage())
                .battingStrikeRate(statsRequest.getBattingStrikeRate())
                .economy(statsRequest.getEconomy())
                .notOuts(statsRequest.getNotOuts())
                .fours(statsRequest.getFours())
                .sixes(statsRequest.getSixes())
                .fifties(statsRequest.getFifties())
                .hundreds(statsRequest.getHundreds())
                .doubleHundreds(statsRequest.getDoubleHundreds())
                .fiveWickets(statsRequest.getFiveWickets())
                .build();
    }
}
