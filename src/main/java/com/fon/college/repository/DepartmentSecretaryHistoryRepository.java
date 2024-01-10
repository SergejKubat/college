package com.fon.college.repository;

import com.fon.college.domain.DepartmentSecretaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentSecretaryHistoryRepository extends JpaRepository<DepartmentSecretaryHistory, Long> {

    List<DepartmentSecretaryHistory> findAllByDepartmentId(long departmentId);

    List<DepartmentSecretaryHistory> findAllBySecretaryId(long secretaryId);

    @Query(value = "SELECT id, department_id, member_id, start_date, end_date FROM department_secretary_history " +
            "WHERE department_id = :departmentId AND member_id = :memberId AND end_date IS NULL;", nativeQuery = true)
    DepartmentSecretaryHistory findPreviousEntry(@Param("departmentId") long departmentId,
                                                 @Param("memberId") long memberId);

}
