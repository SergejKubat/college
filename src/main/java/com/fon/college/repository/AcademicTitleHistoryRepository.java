package com.fon.college.repository;

import com.fon.college.domain.AcademicTitleHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademicTitleHistoryRepository extends JpaRepository<AcademicTitleHistory, Long> {

    List<AcademicTitleHistory> findAllByMemberId(long memberId);

    @Query(value = "SELECT id, member_id, academic_title_id, scientific_field_id, start_date, end_date FROM " +
            "academic_title_history WHERE member_id = :id AND end_date IS NULL;", nativeQuery = true)
    AcademicTitleHistory findPreviousEntry(@Param("id") long memberId);

}
