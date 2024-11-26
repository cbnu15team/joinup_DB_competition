package com.example.joinup3.Competition.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data // Lombok을 사용하여 Getter, Setter, toString 등 자동 생성
@AllArgsConstructor // 모든 필드를 포함하는 생성자 생성
public class CompetitionPageDTO {

    private String title;         // 게시글 제목
    private String authorName;    // 작성자 이름
    private Integer viewCount;    // 방문자 수
    private LocalDateTime createdAt; // 작성 시간
}
