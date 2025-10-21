package com.example.cricBuzz_backend.model.entity;

import com.example.cricBuzz_backend.model.enum_classes.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
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

    int capNumber;

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

    @OneToOne(mappedBy = "player")
    Stats stats;

}
