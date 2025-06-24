package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.domain.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
