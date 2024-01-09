package com.fon.college.repository;

import com.fon.college.domain.DepartmentManagerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentManagerHistoryRepository extends JpaRepository<DepartmentManagerHistory, Long> {

    List<DepartmentManagerHistory> findAllByDepartmentId(long departmentId);

    List<DepartmentManagerHistory> findAllByManagerId(long memberId);

}
