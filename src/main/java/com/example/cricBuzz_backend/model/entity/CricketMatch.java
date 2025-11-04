package com.example.cricBuzz_backend.model.entity;

import com.example.cricBuzz_backend.model.enum_classes.MatchType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CricketMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int matchId;

    String title;

    MatchType matchType;

    int overs;

    String place;

    @CreationTimestamp // the moment I will add a value in the database , it stores the current date from the system
    Date startedAt;

    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;

    @ManyToMany
    @JoinTable( name = "match_team",
    joinColumns = @JoinColumn(name = "match_Id"),
    inverseJoinColumns = @JoinColumn(name = "team_Id"))
    List<Team> teams = new ArrayList<>();

}
