package com.example.cricBuzz_backend.model.entity;

import com.example.cricBuzz_backend.model.enum_classes.MatchType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int statsId;


    @Enumerated(EnumType.STRING)
    MatchType matchType; // TEST, ODI, T20I, IPL

    // ---- Batting ----
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

    @OneToOne
    @JoinColumn
    Player player;
}
