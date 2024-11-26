package com.example.joinup3.Competition.entity;

import com.example.joinup3.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "competitiondetails") // DB의 competitiondetails 테이블과 매핑
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment 설정
    @Column(name = "details_id")
    private Integer detailsId; // 상세글 고유 ID

    @ManyToOne(fetch = FetchType.LAZY) // User와 다대일 관계 설정
    @JoinColumn(name = "user_id", nullable = false) // user_id 외래 키
    private User user; // 작성자 정보

    @Column(name = "title", nullable = false, length = 100)
    private String title; // 상세글 제목

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content; // 상세글 본문

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt; // 상세글 등록 날짜

    @Column(name = "view_count", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer viewCount; // 방문자 수
}
