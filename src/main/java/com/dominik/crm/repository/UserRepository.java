package com.dominik.crm.repository;

import com.dominik.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.UnresolvedAddressException;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername (String username);
}
