package com.example.cricBuzz_backend.dto.response;

import com.example.cricBuzz_backend.model.enum_classes.MatchType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CricketMatchResponse {

    String title;

    MatchType matchType;

    String place;

    Date startedAt;

    List<TeamResponse> teams;
}
