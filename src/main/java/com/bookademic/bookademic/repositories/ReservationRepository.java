package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
