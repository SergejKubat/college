package com.fon.college.repository;

import com.fon.college.domain.AcademicTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicTitleRepository extends JpaRepository<AcademicTitle, Long> {
}
