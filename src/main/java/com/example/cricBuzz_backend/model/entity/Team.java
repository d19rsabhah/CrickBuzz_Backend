package com.example.cricBuzz_backend.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int teamId;

    String teamName;

    int iccRanking;

    int iccPoints;

    @OneToMany(mappedBy = "team")
    List<CricketMatch> cricketMatches = new ArrayList<>();

    @ManyToMany(mappedBy = "teams")
    List<CricketMatch> matches = new ArrayList<>();

}
