package com.example.cricBuzz_backend.repository;

import com.example.cricBuzz_backend.model.entity.CricketMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CricketMatchRepository extends JpaRepository<CricketMatch, Integer> {
}
