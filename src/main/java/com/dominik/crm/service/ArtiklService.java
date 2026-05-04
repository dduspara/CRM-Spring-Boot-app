package com.dominik.crm.service;

import com.dominik.crm.repository.ArtiklRepository;
import com.dominik.crm.entity.Artikl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtiklService {
    private final ArtiklRepository artiklRepository;

    public ArtiklService(ArtiklRepository artiklRepository) {
        this.artiklRepository = artiklRepository;
    }
    public Artikl spremi (Artikl artikl) {
        return artiklRepository.save(artikl);
    }
    public List<Artikl> sviArtikli() {
        return artiklRepository.findAll();
    }
}
