package com.dominik.crm.repository;

import com.dominik.crm.entity.Prodaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ProdajaRepository extends JpaRepository<Prodaja, Long> {
    @Query ("SELECT COALESCE (SUM(p.cijena), 0) FROM Prodaja p WHERE p.kupac.id = :id")
    Double ukupnoPoKupcu(@Param("id") Long id);

    @Query("SELECT COALESCE(SUM(p.cijena), 0) FROM Prodaja p WHERE p.kupac.id = :id AND p.datum BETWEEN :from AND :to")
    Double ukupnoPoKupcuURasponu(
            @Param("id") Long id,
            @Param("from")LocalDate from,
            @Param("to") LocalDate to
            );
}
