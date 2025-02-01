package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Articolo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/articoli")
public class ArticoloController {

    @GetMapping
    public List<Articolo> getArticoli() {
        List<Articolo> articoli = new ArrayList<>();
        articoli.add(new Articolo("1", "Maglietta", "T-shirt", "Maglietta termica", 19.99, "./img/t-shirt.png"));
        articoli.add(new Articolo("2", "Jeans", "Pantaloni", "Pantalone termico", 49.99, "./img/jeans.png"));
        articoli.add(new Articolo("3", "Scarpe da ginnastica", "Scarpe", "Scarpe adatte alla corsa", 89.99, "./img/scarpe.png"));
        articoli.add(new Articolo("4", "Felpa", "Maglione", "Felpa con cappuccio", 39.99, "./img/felpa.png"));
        return articoli;
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Articolo> getArticoloById(@PathVariable String id) {
        List<Articolo> articoli = getArticoli(); // Richiama il metodo esistente
        return articoli.stream()
            .filter(articolo -> articolo.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Articolo>> getArticoliByCategoria(@PathVariable String categoria) {
        List<Articolo> articoli = getArticoli();
        List<Articolo> articoliFiltrati = articoli.stream()
                .filter(articolo -> articolo.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
        if (articoliFiltrati.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(articoliFiltrati);
    }
}