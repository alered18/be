package com.ecommerce.ecommerce.model;

public class Articolo {
    private String id;
    private String nome;
    private String categoria;
    private String descrizione;
    private double prezzo;
    private String immagineUrl;

    public Articolo(String id, String nome, String categoria, String descrizione, double prezzo, String immagineUrl) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.immagineUrl = immagineUrl;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getimmagineUrl() {
        return immagineUrl;
    }

    public void setimmagineUrl(String immagineUrl) {
        this.immagineUrl = immagineUrl;
    }
}
