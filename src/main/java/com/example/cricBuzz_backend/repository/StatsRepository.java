package com.example.cricBuzz_backend.repository;

import com.example.cricBuzz_backend.model.entity.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats, Integer> {
}