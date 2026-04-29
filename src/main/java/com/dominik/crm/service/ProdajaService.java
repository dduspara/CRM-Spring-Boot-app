package com.dominik.crm.service;

import com.dominik.crm.entity.Artikl;
import com.dominik.crm.repository.ArtiklRepository;
import com.dominik.crm.repository.ProdajaRepository;
import com.dominik.crm.entity.Prodaja;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProdajaService {

    private final ProdajaRepository prodajaRepository;
    private final ArtiklRepository artiklRepository;

    public ProdajaService(ProdajaRepository prodajaRepository, ArtiklRepository artiklRepository) {

        this.prodajaRepository = prodajaRepository;
        this.artiklRepository = artiklRepository;
    }
    public Prodaja spremi (Prodaja prodaja){
        Artikl artikl = artiklRepository
                .findById(prodaja.getArtikl().getId())
                .orElseThrow(() -> new RuntimeException("Artikl ne postoji"));
        double ukupno = artikl.getCijena() * prodaja.getKolicina();
        prodaja.setArtikl(artikl);
        prodaja.setCijena(ukupno);
        return prodajaRepository.save(prodaja);
    }
;    public List<Prodaja> sveProdaje(){

        return prodajaRepository.findAll();
    }
    public Double ukupnoPoKupcu (Long kupacId) {
        List<Prodaja> prodaje = prodajaRepository.findAll();
        return prodaje.stream()
                .filter(p -> p.getKupac().getId().equals(kupacId))
                .mapToDouble(Prodaja::getCijena)
                .sum();
    }

    public double ukupnoPoKupcuURasponu (Long kupacId, LocalDate from, LocalDate to){
        List<Prodaja> prodaje   = prodajaRepository.findAll();
        return prodaje.stream()
                .filter(p-> p.getKupac().getId().equals(kupacId))
                .filter(p-> p.getDatum().isAfter(from) || p.getDatum().isEqual(from))
                .filter(p->p.getDatum().isBefore(to) || p.getDatum().isEqual(to))
                .mapToDouble(Prodaja::getCijena)
                .sum();
    }
}
