package com.example.cricBuzz_backend.model.entity;

import com.example.cricBuzz_backend.model.enum_classes.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int playerId;

    public String name;
    int age;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    Gender gender;

    double height;

    double weight;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    Specialization speciality;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    Role role;

    int jerseyNumber;

    int capNumberTest;

    int capNumberODI;

    int capNumberT20;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    BattingStyle battingStyle;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    BowlingStyle bowlingStyle;

    LocalDate debutDate;

    LocalDate lastMatchDate;

    @Enumerated(EnumType.STRING)
    IsActive isActive;

    String nationality;

    String placeOfBirth;

    @ManyToOne
    @JoinColumn(nullable = true)
    Team team;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Stats> statsList = new ArrayList<>();


}
