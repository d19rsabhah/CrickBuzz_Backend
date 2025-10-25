package com.example.cricBuzz_backend.repository;

import com.example.cricBuzz_backend.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
