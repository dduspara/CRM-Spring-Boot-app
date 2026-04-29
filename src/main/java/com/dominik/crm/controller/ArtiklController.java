package com.dominik.crm.controller;

import com.dominik.crm.service.ArtiklService;
import com.dominik.crm.entity.Artikl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artikli")
public class ArtiklController {
    private final ArtiklService artiklService;

    public ArtiklController(ArtiklService artiklService) {
        this.artiklService = artiklService;
    }
    @PostMapping
    public Artikl dodaj(@RequestBody Artikl artikl) {
        return artiklService.spremi(artikl);
    }

    @GetMapping
    public List<Artikl> svi(){
        return artiklService.svi();
    }

}
