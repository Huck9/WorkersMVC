package com.company.model;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Pracownik implements Serializable {
    private String pesel;
    private String imie;
    private String nazwisko;
    private String nrTelefony;
    private BigDecimal wyplata;

    public Pracownik(String pesel, String imie, String nazwisko, String nrTelefony, BigDecimal wyplata) {
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefony = nrTelefony;
        this.wyplata = wyplata;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrTelefony() {
        return nrTelefony;
    }

    public void setNrTelefony(String nrTelefony) {
        this.nrTelefony = nrTelefony;
    }

    public BigDecimal getWyplata() {
        return wyplata;
    }

    public void setWyplata(BigDecimal wyplata) {
        this.wyplata = wyplata;
    }
}
