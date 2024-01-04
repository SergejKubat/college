package com.fon.college.repository;

import com.fon.college.domain.ScientificField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScientificFieldRepository extends JpaRepository<ScientificField, Long> {
}
