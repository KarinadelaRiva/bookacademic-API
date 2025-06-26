package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.domain.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.security.Signature;
import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findByCode(String code);
    List<Subject> findByNameContainingIgnoreCase(String name);
    Boolean existsByCode(String code);

    @Query("SELECT s FROM Subject s JOIN s.degreePrograms d WHERE d.id = :degreeProgramId")
    List<Subject> findByDegreeProgramId(@Param("degreeProgramId") Long degreeProgramId);
}
