package com.example.cricBuzz_backend.dto.request;

import com.example.cricBuzz_backend.model.enum_classes.MatchType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CricketMatchRequest {

    String title;

    MatchType matchType;

    int overs;

    String place;
}
