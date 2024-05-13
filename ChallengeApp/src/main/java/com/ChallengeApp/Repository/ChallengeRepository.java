package com.ChallengeApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ChallengeApp.Dto.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Long>{

	Optional<Challenge> findByMonthIgnoreCase(String month);

	
}
