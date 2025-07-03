package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByCode(String code);
    Boolean existsByCode(String code);
    Boolean existsByName(String name);
    List<Role> findByNameContainingIgnoreCase(String partialName);
}
