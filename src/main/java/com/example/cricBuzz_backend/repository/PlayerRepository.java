package com.example.cricBuzz_backend.repository;

import com.example.cricBuzz_backend.model.entity.Player;
import com.example.cricBuzz_backend.model.entity.Team;
import com.example.cricBuzz_backend.model.enum_classes.Gender;
import com.example.cricBuzz_backend.model.enum_classes.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Integer>{

    List<Player> findByGender(Gender gender);

    @Query(value = "SELECT * FROM PLAYER WHERE gender = :gender AND speciality = :specialization", nativeQuery = true)
    List<Player> findPlayerBasedOnGenderAndSpeciality(@Param("gender") String gender,
                                                      @Param("specialization") String specialization);

    //positional arguments
//    @Query("SELECT * FROM PLAYER WHERE gender = ?1 AND speciality = ?2")
//    List<Player> findPlayerBasedOnGenderAndSpeciality(@Param("gender") Gender gender,
//                                                      @Param("specialization") Specialization specialization);

    // non native query , called JPQL. Writing query based on class attributes
//    @Query(value = "SELECT p FROM Player p WHERE p.gender = :gender AND p.speciality = :specialization", nativeQuery = false)
//    List<Player> findPlayerBasedOnGenderAndSpeciality(@Param("gender") Gender gender,
//                                                      @Param("specialization") Specialization specialization);

    Optional<Player> findByTeamAndNameAndCapNumberODI(Team team, String playerName, int capNumberODI);

}
