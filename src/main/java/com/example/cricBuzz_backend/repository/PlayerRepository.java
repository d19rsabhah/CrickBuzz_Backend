package com.example.cricBuzz_backend.repository;

import com.example.cricBuzz_backend.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository <Player, Integer>{
}
