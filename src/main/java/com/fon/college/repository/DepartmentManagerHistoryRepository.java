package com.fon.college.repository;

import com.fon.college.domain.DepartmentManagerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentManagerHistoryRepository extends JpaRepository<DepartmentManagerHistory, Long> {

    List<DepartmentManagerHistory> findAllByDepartmentId(long departmentId);

    List<DepartmentManagerHistory> findAllByManagerId(long memberId);

    @Query(value = "SELECT id, department_id, member_id, start_date, end_date FROM department_manager_history " +
            "WHERE department_id = :departmentId AND member_id = :memberId AND end_date IS NULL;", nativeQuery = true)
    DepartmentManagerHistory findPreviousEntry(@Param("departmentId") long departmentId,
                                               @Param("memberId") long memberId);

}
