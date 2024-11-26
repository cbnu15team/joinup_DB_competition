package com.example.joinup3.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // 로그인 ID로 User 조회
    Optional<User> findById(String id);
}
