package com.dominik.crm.controller;

import com.dominik.crm.service.ProdajaService;
import com.dominik.crm.entity.Prodaja;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prodaje")
public class ProdajaController {

    private final ProdajaService prodajaService;

    public ProdajaController(ProdajaService prodajaService) {
        this.prodajaService = prodajaService;
    }

    @GetMapping
    public List<Prodaja> sveProdaje() {
        return prodajaService.sveProdaje();
    }

    @PostMapping
    public Prodaja dodajProdaju (@RequestBody Prodaja prodaja) {
        return prodajaService.spremi(prodaja);
    }

    @GetMapping("/kupac/{id}/ukupno")
    public Double ukupnoPoKupcu (
            @PathVariable Long id,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to
            ) {
        return prodajaService.ukupnoPoKupcuURasponu(id, from, to);
    }




}
