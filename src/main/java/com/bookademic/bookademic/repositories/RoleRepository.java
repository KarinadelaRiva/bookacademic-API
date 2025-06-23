package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
