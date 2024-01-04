package com.fon.college.repository;

import com.fon.college.domain.DepartmentManagerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentManagerHistoryRepository extends JpaRepository<DepartmentManagerHistory, Long> {
}
