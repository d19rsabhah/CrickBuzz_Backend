package com.example.cricBuzz_backend.dto.request;

import com.example.cricBuzz_backend.model.enum_classes.MatchType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatsRequest {

    MatchType matchType; // TEST, ODI, T20I, IPL
    int matches;
    int ballsBowled;
    int inningsBatted;
    int inningsBowled;
    int runsConceded;
    int runs;
    int wickets;
    int ballsFaced;
    int highestScore;
    double battingAverage;
    double bowlingAverage;
    double battingStrikeRate;
    double economy;
    int notOuts;
    int fours;
    int sixes;
    int fifties;
    int hundreds;
    int doubleHundreds;
    int fiveWickets;
    int tenWickets;
}
