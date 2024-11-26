package com.example.joinup3.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users") // DB의 users 테이블과 매핑
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment 설정
    @Column(name = "user_id") // PRIMARY KEY
    private Integer userId;

    @Column(name = "id", nullable = false, unique = true, length = 10) // 로그인 ID
    private String id;

    @Column(name = "password", nullable = false, length = 10) // 로그인 비밀번호
    private String password;

    @Column(name = "real_name", nullable = false, length = 20) // 사용자 실명
    private String realName;

    @Column(name = "birth", nullable = false, length = 8) // 생년월일
    private String birth;

    @Column(name = "phone", nullable = false, unique = true, length = 11) // 전화번호
    @Pattern(regexp = "^010\\d{8}$", message = "전화번호는 010으로 시작하고 뒤에 숫자 8자가 와야 합니다.")
    private String phone;
}
