package com.example.springBootK8s.repo;

import com.example.springBootK8s.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository <User,Long> {
}
