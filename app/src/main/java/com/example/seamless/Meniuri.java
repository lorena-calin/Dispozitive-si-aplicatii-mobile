package com.example.seamless;

public class Meniuri {
    private String nume;
    private float recenzie;
    private String livrare;
    private String oferta;

    public Meniuri(String nume, float recenzie, String livrare, String oferta) {
        this.nume = nume;
        this.recenzie = recenzie;
        this.livrare = livrare;
        this.oferta = oferta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getRecenzie() {
        return recenzie;
    }

    public void setRecenzie(float recenzie) {
        this.recenzie = recenzie;
    }

    public String getLivrare() {
        return livrare;
    }

    public void setLivrare(String livrare) {
        this.livrare = livrare;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    @Override
    public String toString() {
        return "Meniuri{" +
                "nume='" + nume + '\'' +
                ", recenzie=" + recenzie +
                ", livrare='" + livrare + '\'' +
                ", oferta='" + oferta + '\'' +
                '}';
    }
}
