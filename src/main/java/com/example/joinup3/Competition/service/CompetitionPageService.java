package com.example.joinup3.Competition.service;

import com.example.joinup3.Competition.dto.CompetitionPageDTO;
import com.example.joinup3.Competition.repository.CompetitionDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionDetailsService {

    private final CompetitionDetailsRepository competitionDetailsRepository;

    public CompetitionDetailsService(CompetitionDetailsRepository repository) {
        this.competitionDetailsRepository = repository;
    }

    // 게시글 목록 조회
    public List<CompetitionPageDTO> getAllCompetitionPages() {
        return competitionDetailsRepository.findAllCompetitionPages();
    }
}
