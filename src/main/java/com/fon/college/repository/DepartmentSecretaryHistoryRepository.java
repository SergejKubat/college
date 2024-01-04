package com.fon.college.repository;

import com.fon.college.domain.DepartmentSecretaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentSecretaryHistoryRepository extends JpaRepository<DepartmentSecretaryHistory, Long> {
}
