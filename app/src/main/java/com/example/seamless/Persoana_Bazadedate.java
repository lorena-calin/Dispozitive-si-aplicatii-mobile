package com.example.seamless;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "clienti")
public class Persoana_Bazadedate {

    @PrimaryKey(autoGenerate = true)
    private int idclient;

    @ColumnInfo (name = "nume")
    private String nume;

    @ColumnInfo (name="email")
    private String email;

    @ColumnInfo (name="parola")
    private String parola;

    @ColumnInfo (name="numar comenzi")
    private int nrcomenzi;

    public Persoana_Bazadedate(int idclient, String nume, String email, String parola, int nrcomenzi) {
        this.nume = nume;
        this.email = email;
        this.parola = parola;
        this.nrcomenzi = nrcomenzi;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
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

    public int getNrcomenzi() {
        return nrcomenzi;
    }

    public void setNrcomenzi(int nrcomenzi) {
        this.nrcomenzi = nrcomenzi;
    }

    @Override
    public String toString() {
        return "Persoana_Bazadedate{" +
                "idclient=" + idclient +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                ", nrcomenzi='" + nrcomenzi + '\'' +
                '}';
    }
}
