package com.fon.college.repository;

import com.fon.college.domain.DepartmentSecretaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentSecretaryHistoryRepository extends JpaRepository<DepartmentSecretaryHistory, Long> {

    List<DepartmentSecretaryHistory> findAllByDepartmentId(long departmentId);

    List<DepartmentSecretaryHistory> findAllBySecretaryId(long secretaryId);

}
