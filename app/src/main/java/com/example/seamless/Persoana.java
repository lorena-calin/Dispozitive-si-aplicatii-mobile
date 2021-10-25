package com.example.seamless;

import java.io.Serializable;

public class Persoana implements Serializable {
    private String nume;
    private String email;
    private String parola;
    private String adresa;


    public Persoana() {
    }

    public Persoana(String nume, String email, String parola,String adresa) {
        this.nume = nume;
        this.email = email;
        this.parola = parola;
        this.adresa=adresa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
