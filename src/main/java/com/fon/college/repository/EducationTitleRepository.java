package com.fon.college.repository;

import com.fon.college.domain.EducationTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTitleRepository extends JpaRepository<EducationTitle, Long> {
}
