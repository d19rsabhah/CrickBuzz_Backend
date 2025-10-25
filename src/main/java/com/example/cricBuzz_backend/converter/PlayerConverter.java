package com.example.cricBuzz_backend.converter;

import com.example.cricBuzz_backend.dto.request.PlayerRequest;
import com.example.cricBuzz_backend.dto.response.PlayerResponse;
import com.example.cricBuzz_backend.model.entity.Player;

public class PlayerConverter {

    public static Player playerRequestToPlayer(PlayerRequest playerRequest){

        return Player.builder()
                .name(playerRequest.getName())
                .age(playerRequest.getAge())
                .gender(playerRequest.getGender())
                .height(playerRequest.getHeight())
                .weight(playerRequest.getWeight())
                .speciality(playerRequest.getSpeciality())
                .role(playerRequest.getRole())
                .jerseyNumber(playerRequest.getJerseyNumber())
                .capNumber(playerRequest.getCapNumber())
                .battingStyle(playerRequest.getBattingStyle())
                .bowlingStyle(playerRequest.getBowlingStyle())
                .debutDate(playerRequest.getDebutDate())
                .lastMatchDate(playerRequest.getLastMatchDate())
                .isActive(playerRequest.getIsActive())
                .nationality(playerRequest.getNationality())
                .placeOfBirth(playerRequest.getPlaceOfBirth())
                .build();
    }

    public static PlayerResponse playerToPlayerResponse(Player player){
        return PlayerResponse.builder()
                .name(player.getName())
                .speciality(player.getSpeciality())
                .build();

    }

}
