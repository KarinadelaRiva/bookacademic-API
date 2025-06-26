package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
