package com.example.joinup3.Competition.controller;

import com.example.joinup3.Competition.entity.CompetitionDetails;
import com.example.joinup3.Competition.service.CompetitionDetailsService;
import com.example.joinup3.User.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competition-details")
public class CompetitionDetailsController {

    private final CompetitionDetailsService competitionDetailsService;

    public CompetitionDetailsController(CompetitionDetailsService service) {
        this.competitionDetailsService = service;
    }

    // 상세글 생성
    @PostMapping
    public ResponseEntity<CompetitionDetails> createCompetitionDetails(
            @RequestBody CompetitionDetails details,
            @AuthenticationPrincipal User currentUser) {
        CompetitionDetails createdDetails = competitionDetailsService.createCompetitionDetails(details, currentUser);
        return ResponseEntity.ok(createdDetails);
    }

    // 상세글 ID로 조회
    @GetMapping("/{detailsId}")
    public ResponseEntity<CompetitionDetails> getCompetitionDetailsById(@PathVariable Integer detailsId) {
        CompetitionDetails details = competitionDetailsService.getCompetitionDetailsById(detailsId);
        return ResponseEntity.ok(details);
    }

    // 모든 상세글 조회
    @GetMapping
    public ResponseEntity<List<CompetitionDetails>> getAllCompetitionDetails() {
        List<CompetitionDetails> detailsList = competitionDetailsService.getAllCompetitionDetails();
        return ResponseEntity.ok(detailsList);
    }

    // 상세글 수정
    @PutMapping("/{detailsId}")
    public ResponseEntity<CompetitionDetails> updateCompetitionDetails(
            @PathVariable Integer detailsId,
            @RequestBody CompetitionDetails updatedDetails,
            @AuthenticationPrincipal User currentUser) {
        CompetitionDetails updated = competitionDetailsService.updateCompetitionDetails(detailsId, updatedDetails, currentUser);
        return ResponseEntity.ok(updated);
    }

    // 상세글 삭제
    @DeleteMapping("/{detailsId}")
    public ResponseEntity<String> deleteCompetitionDetails(
            @PathVariable Integer detailsId,
            @AuthenticationPrincipal User currentUser) {
        competitionDetailsService.deleteCompetitionDetails(detailsId, currentUser);
        return ResponseEntity.ok("상세글이 삭제되었습니다.");
    }

    // 방문자 수 증가
    @PostMapping("/{detailsId}/increment-view")
    public ResponseEntity<String> incrementViewCount(@PathVariable Integer detailsId) {
        competitionDetailsService.incrementViewCount(detailsId);
        return ResponseEntity.ok("방문자 수가 증가되었습니다.");
    }
}
