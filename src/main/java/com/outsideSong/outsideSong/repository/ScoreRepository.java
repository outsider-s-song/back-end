package com.outsideSong.outsideSong.repository;

import com.outsideSong.outsideSong.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
