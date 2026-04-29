package com.dominik.crm.repository;

import com.dominik.crm.entity.Artikl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtiklRepository extends JpaRepository<Artikl, Long> {
}
