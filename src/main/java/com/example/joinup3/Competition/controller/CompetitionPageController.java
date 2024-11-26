package com.example.joinup3.Competition.controller;

import com.example.joinup3.Competition.dto.CompetitionPageDTO;
import com.example.joinup3.Competition.service.CompetitionDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/competition-pages")
public class CompetitionDetailsController {

    private final CompetitionDetailsService competitionDetailsService;

    public CompetitionDetailsController(CompetitionDetailsService service) {
        this.competitionDetailsService = service;
    }

    // 게시글 목록 조회
    @GetMapping
    public ResponseEntity<List<CompetitionPageDTO>> getAllCompetitionPages() {
        List<CompetitionPageDTO> pages = competitionDetailsService.getAllCompetitionPages();
        return ResponseEntity.ok(pages);
    }
}
