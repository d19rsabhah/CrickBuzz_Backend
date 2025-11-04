package com.example.cricBuzz_backend.dto.response;

import com.example.cricBuzz_backend.model.enum_classes.Specialization;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PlayerResponse {
    String name;
    Specialization speciality;
    String teamName;
}
