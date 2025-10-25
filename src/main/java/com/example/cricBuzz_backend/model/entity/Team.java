package com.example.cricBuzz_backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
            @JsonIgnore
    List<CricketMatch> cricketMatches = new ArrayList<>();

    @ManyToMany(mappedBy = "teams")
            @JsonIgnore
    List<CricketMatch> matches = new ArrayList<>();

}
