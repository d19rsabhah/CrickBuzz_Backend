package com.example.cricBuzz_backend.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TeamResponse {
    String teamName;
    int iccRanking;
}
