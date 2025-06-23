package com.bookademic.bookademic.repositories;

import com.bookademic.bookademic.entities.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
}
