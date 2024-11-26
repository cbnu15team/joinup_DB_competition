package com.example.joinup3.Competition.repository;

import com.example.joinup3.Competition.dto.CompetitionPageDTO;
import com.example.joinup3.Competition.entity.CompetitionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionDetailsRepository extends JpaRepository<CompetitionDetails, Integer> {

    // DTO를 반환하는 JPQL 쿼리 작성
    @Query("SELECT new com.example.joinup3.Competition.dto.CompetitionPageDTO( " +
            "cd.title, u.realName, cd.viewCount, cd.createdAt) " +
            "FROM CompetitionDetails cd " +
            "JOIN cd.user u")
    List<CompetitionPageDTO> findAllCompetitionPages();
}
