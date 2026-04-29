package com.dominik.crm.service;

import com.dominik.crm.repository.KupacRepository;
import com.dominik.crm.entity.Kupac;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KupacService {
    private final KupacRepository kupacRepository;


    public KupacService(KupacRepository kupacRepository) {
        this.kupacRepository = kupacRepository;
    }
    public List<Kupac> sviKupci() {
        return kupacRepository.findAll();
    }
    public Kupac spremiKupca(Kupac kupac){
        return kupacRepository.save(kupac);
    }
}
