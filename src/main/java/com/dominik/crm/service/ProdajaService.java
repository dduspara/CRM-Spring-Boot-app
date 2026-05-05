package com.dominik.crm.service;

import com.dominik.crm.entity.Artikl;
import com.dominik.crm.entity.Kupac;
import com.dominik.crm.repository.ArtiklRepository;
import com.dominik.crm.repository.KupacRepository;
import com.dominik.crm.repository.ProdajaRepository;
import com.dominik.crm.entity.Prodaja;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProdajaService {

    private final ProdajaRepository prodajaRepository;
    private final ArtiklRepository artiklRepository;
    private final KupacRepository kupacRepository;

    public ProdajaService(ProdajaRepository prodajaRepository, ArtiklRepository artiklRepository, KupacRepository kupacRepository) {

        this.prodajaRepository = prodajaRepository;
        this.artiklRepository = artiklRepository;
        this.kupacRepository = kupacRepository;
    }
    public Prodaja spremi (Prodaja prodaja){
        Kupac kupac = kupacRepository
                .findById(prodaja.getKupac().getId())
                .orElseThrow(()-> new RuntimeException("Kupac ne postoji"));

        Artikl artikl = artiklRepository
                .findById(prodaja.getArtikl().getId())
                .orElseThrow(() -> new RuntimeException("Artikl ne postoji"));
        double ukupno = artikl.getCijena() * prodaja.getKolicina();

        prodaja.setKupac(kupac);
        prodaja.setArtikl(artikl);
        prodaja.setCijena(ukupno);
        return prodajaRepository.save(prodaja);
    }
    public List<Prodaja> sveProdaje(){

        return prodajaRepository.findAll();
    }
    public Double ukupnoPoKupcu (Long kupacId) {
        return prodajaRepository.ukupnoPoKupcu(kupacId);
    }

    public Double ukupnoPoKupcuURasponu (Long kupacId, LocalDate from, LocalDate to){
        return prodajaRepository.ukupnoPoKupcuURasponu(kupacId, from, to);
    }
}
