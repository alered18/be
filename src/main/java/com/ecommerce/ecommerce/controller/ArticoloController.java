package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Articolo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/articoli")
public class ArticoloController {

    @GetMapping
    public List<Articolo> getArticoli() {
        List<Articolo> articoli = new ArrayList<>();
        articoli.add(new Articolo("1", "Maglietta", "T-shirt", "Maglietta termica", 19.99, "/images/t-shirt.png"));
        articoli.add(new Articolo("2", "Jeans", "Pantaloni", "Pantalone termico", 49.99, "/images/jeans.png"));
        articoli.add(new Articolo("3", "Scarpe da ginnastica", "Scarpe", "Scarpe adatte alla corsa", 89.99, "/images/scarpe.png"));
        articoli.add(new Articolo("4", "Felpa", "Maglione", "Felpa con cappuccio", 39.99, "/images/felpa.png"));
        return articoli;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articolo> getArticoloById(@PathVariable String id) {
        List<Articolo> articoli = getArticoli(); // Richiama il metodo esistente
        return articoli.stream()
            .filter(articolo -> articolo.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}