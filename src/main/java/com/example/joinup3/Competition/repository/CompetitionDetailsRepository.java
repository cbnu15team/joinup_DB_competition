package com.example.joinup3.Competition.repository;

import com.example.joinup3.Competition.entity.CompetitionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionDetailsRepository extends JpaRepository<CompetitionDetails, Integer> {
    // 필요한 경우 커스텀 쿼리 작성 가능
}
