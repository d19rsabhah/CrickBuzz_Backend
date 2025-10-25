package com.example.cricBuzz_backend.dto.request;

import com.example.cricBuzz_backend.model.enum_classes.*;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerRequest {
    public String name;

    int age;

    Gender gender;

    double height;

    double weight;

    Specialization speciality;

    Role role;

    int jerseyNumber;

    int capNumber;

    BattingStyle battingStyle;

    BowlingStyle bowlingStyle;

    LocalDate debutDate;

    LocalDate lastMatchDate;

    IsActive isActive;

    String nationality;

    String placeOfBirth;
}
