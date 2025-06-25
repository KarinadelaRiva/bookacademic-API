package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.domain.entities.DegreeProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DegreeProgramRepository extends JpaRepository<DegreeProgram, Long> {
    Optional<DegreeProgram> findByCode(String code);
    List<DegreeProgram> findByNombreContainingIgnoreCase(String nombre);
    Boolean existsByCode(String code);
}
