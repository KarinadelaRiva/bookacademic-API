package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.domain.entities.DegreeProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeProgramRepository extends JpaRepository<DegreeProgram, Long> {
}
