package com.example.joinup3.Competition.service;

import com.example.joinup3.Competition.entity.CompetitionDetails;
import com.example.joinup3.Competition.repository.CompetitionDetailsRepository;
import com.example.joinup3.User.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionDetailsService {

    private final CompetitionDetailsRepository competitionDetailsRepository;

    public CompetitionDetailsService(CompetitionDetailsRepository repository) {
        this.competitionDetailsRepository = repository;
    }

    // 상세글 생성
    public CompetitionDetails createCompetitionDetails(CompetitionDetails details, User user) {
        details.setUser(user); // 작성자 설정
        details.setViewCount(0); // 방문자 수 초기화
        return competitionDetailsRepository.save(details);
    }

    // 상세글 조회 (ID로 조회)
    public CompetitionDetails getCompetitionDetailsById(Integer detailsId) {
        return competitionDetailsRepository.findById(detailsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상세글을 찾을 수 없습니다."));
    }

    // 모든 상세글 조회
    public List<CompetitionDetails> getAllCompetitionDetails() {
        return competitionDetailsRepository.findAll();
    }

    // 상세글 수정
    public CompetitionDetails updateCompetitionDetails(Integer detailsId, CompetitionDetails updatedDetails, User currentUser) {
        CompetitionDetails existingDetails = competitionDetailsRepository.findById(detailsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상세글을 찾을 수 없습니다."));

        // 작성자 검증
        if (!existingDetails.getUser().getUserId().equals(currentUser.getUserId())) {
            throw new SecurityException("작성자만 수정할 수 있습니다.");
        }

        // 데이터 업데이트
        existingDetails.setTitle(updatedDetails.getTitle());
        existingDetails.setContent(updatedDetails.getContent());
        return competitionDetailsRepository.save(existingDetails);
    }

    // 상세글 삭제
    public void deleteCompetitionDetails(Integer detailsId, User currentUser) {
        CompetitionDetails existingDetails = competitionDetailsRepository.findById(detailsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상세글을 찾을 수 없습니다."));

        // 작성자 검증
        if (!existingDetails.getUser().getUserId().equals(currentUser.getUserId())) {
            throw new SecurityException("작성자만 삭제할 수 있습니다.");
        }

        competitionDetailsRepository.delete(existingDetails);
    }

    // 방문자 수 증가
    public void incrementViewCount(Integer detailsId) {
        CompetitionDetails details = competitionDetailsRepository.findById(detailsId)
                .orElseThrow(() -> new IllegalArgumentException("해당 상세글을 찾을 수 없습니다."));
        details.setViewCount(details.getViewCount() + 1);
        competitionDetailsRepository.save(details);
    }
}
