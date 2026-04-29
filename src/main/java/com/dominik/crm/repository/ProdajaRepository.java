package com.dominik.crm.repository;

import com.dominik.crm.entity.Prodaja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdajaRepository extends JpaRepository<Prodaja, Long> {
    @Query ("SELECT SUM(p.cijena * p.kolicina) FROM Prodaja p WHERE p.kupac.id =  :id")
    Double ukupnoPoKupcu (@Param("id") Long id);
}
