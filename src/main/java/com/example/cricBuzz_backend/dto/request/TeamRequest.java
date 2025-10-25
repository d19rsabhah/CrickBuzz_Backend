package com.example.cricBuzz_backend.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamRequest {

    String teamName;

    int iccRanking;

    int iccPoints;

}
