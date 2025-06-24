package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.domain.entities.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepository extends JpaRepository<Space, Long> {
}
