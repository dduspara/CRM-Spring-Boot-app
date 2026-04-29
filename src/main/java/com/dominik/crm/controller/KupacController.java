package com.dominik.crm.controller;

import com.dominik.crm.service.KupacService;
import com.dominik.crm.service.ProdajaService;
import com.dominik.crm.entity.Kupac;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kupci")
public class KupacController {
    private final KupacService kupacService;
    private final ProdajaService prodajaService;
    public KupacController (KupacService kupacService, ProdajaService prodajaService) {
        this.kupacService = kupacService;
        this.prodajaService = prodajaService;
    }
    @GetMapping
    public List<Kupac> sviKupci() {
        return kupacService.sviKupci();
    }

    @PostMapping
    public Kupac dodajKupca (@RequestBody Kupac kupac) {
        return kupacService.spremiKupca(kupac);
    }

    @GetMapping("/{id}/ukupna-prodaja")
    public Double ukupnaProdaja (@PathVariable Long id) {
        return prodajaService.ukupnoPoKupcu(id);
    }
}
