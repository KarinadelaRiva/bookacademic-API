package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
