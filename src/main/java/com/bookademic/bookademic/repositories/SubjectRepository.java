package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
